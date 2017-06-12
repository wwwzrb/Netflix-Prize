import numpy as np
import re
import time
import os
import codecs
import nltk
import numpy
from sklearn import feature_extraction
from sklearn.feature_extraction.text import TfidfVectorizer
from sklearn.metrics.pairwise import cosine_similarity
from nltk.stem.snowball import SnowballStemmer
from sdae.SdA import  SdA
import pandas as pd
import dao
class process():
    titles = []
    synopses = []
    genres = []
    stopwords=[]
    totalvocab_stemmed = []
    totalvocab_tokenized = []

    def __init__(self):
        my_dao = dao.dao()
        results=my_dao.getDocument()
        for row in results:
            self.titles.append(row[2])
            self.synopses.append(row[8])
            self.genres.append(row[15])
        stopwords = nltk.corpus.stopwords.words('english')
        stopwords.append("'s")

    def tf_idf(self):
        for i in self.synopses:
            allwords_stemmed = self.tokenize_and_stem(i)
            self.totalvocab_stemmed.extend(allwords_stemmed)

            allwords_tokenized = self.tokenize_only(i)
            self.totalvocab_tokenized.extend(allwords_tokenized)
        vocab_frame = pd.DataFrame({'words': self.totalvocab_tokenized}, index=self.totalvocab_stemmed)
        print('there are ' + str(vocab_frame.shape[0]) + ' items in vocab_frame')
        print(vocab_frame.head())
        tfidf_vectorizer = TfidfVectorizer(max_df=0.8, max_features=300,
                                           min_df=5, stop_words=self.stopwords,
                                           use_idf=True, tokenizer=self.tokenize_and_stem, ngram_range=(1, 3))
        tfidf_matrix = tfidf_vectorizer.fit_transform(self.synopses).toarray()
        print(tfidf_matrix.shape)
        terms = tfidf_vectorizer.get_feature_names()
        similarity = cosine_similarity(tfidf_matrix)
        # print(similarity)
        return tfidf_matrix,similarity

    def test_SdA(self,pretrain_lr=0.1, pretraining_epochs=1000, corruption_level=0.3, \
                 finetune_lr=0.1, finetune_epochs=200):
        x,s =self.tf_idf()
        print(x)
        print(len(x))
        out=5
        y=numpy.zeros((len(x),out),dtype=float)
        offset=int(len(x[0])/out)
        print(offset)
        for i in range(len(x)):
            for j in range(len(y[i])):
                tmp=0
                for k in range(j*offset,(j+1)*offset):
                    if x[i][k]!=0:
                        tmp+=x[i][k]
                y[i][j]=tmp
        # print(y)
        rng = numpy.random.RandomState(123)
        # construct SdA
        sda = SdA(input=x, label=y, \
                  n_ins=len(x[0]), hidden_layer_sizes=[10,out,10], n_outs=out, rng=rng)

        # pre-training
        sda.pretrain(lr=pretrain_lr, corruption_level=corruption_level, epochs=pretraining_epochs)

        # fine-tuning
        # sda.finetune(lr=finetune_lr, epochs=finetune_epochs)

        # test
        x=sda.predict(x)
        similarity = cosine_similarity(x)
        return x,similarity



    def tokenize_and_stem(self,text):
        stemmer = SnowballStemmer("english")
        tokens = [word for sent in nltk.sent_tokenize(text) for word in nltk.word_tokenize(sent)]
        filtered_tokens = []
        # print(tokens)
        for token in tokens:
            if re.search('[a-zA-Z]', token):
                filtered_tokens.append(token)
        # print(filtered_tokens)
        stems = [stemmer.stem(t) for t in filtered_tokens]
        # print(stems)
        return stems

    def tokenize_only(self,text):
        tokens = [word.lower() for sent in nltk.sent_tokenize(text) for word in nltk.word_tokenize(sent)]
        filtered_tokens = []
        for token in tokens:
            if re.search('[a-zA-Z]', token):
                filtered_tokens.append(token)
        return filtered_tokens
