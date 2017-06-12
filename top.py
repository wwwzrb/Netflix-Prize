import dao
import numpy
import pandas

class top():

    dao=dao.dao()

    def __init__(self,S,N,M):

        self.ToU = numpy.zeros((N, M),dtype=float)
        self.S=S

    def Caculate(self,R):

        self.R = R
        for row in self.R:
            movieId=row[0]
            userId=row[1]
            self.rating=self.dao.getToURating(movieId,userId)
            similar=[]
            ratings=[]
            #print(movieId)
            # print(userId)
            for result in self.rating:
                similar.append(self.S[movieId-1][result[0]-1])
                ratings.append(result[2])
            similar_frame=pandas.DataFrame({'Rating':ratings},index=similar)
            similar_frame=similar_frame.sort_index(ascending=False)
            if len(similar)==0:
                continue
            sum=0
            ratings=similar_frame['Rating']
            if len(similar)<=20:
               length=len(similar)
            else:
                length=20
            for i in range(length):
                sum=sum+ratings.data[i]
            # print(sum/length)
            self.ToU[movieId][userId]=numpy.float(sum/length)
        return self.ToU
