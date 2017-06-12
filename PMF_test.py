# coding=utf-8

import numpy
import pandas
import process
import dao
import top
def matrix_factorization(R, P, Q, K, steps=50, alpha=0.005, yu=0.01, yv=0.001):
    Q=Q.T
    for step in range(steps):
        for i in range(1,len(R)):
            for j in range(1,len(R[i])):
                eij=R[i][j]-numpy.dot(P[i,:],Q[:,j])
                for k in range(K):
                    P[i][k]=P[i][k]+alpha*(eij*Q[k][j]-yu*P[i][k])
                    Q[k][j]=Q[k][j]+alpha*(eij*P[i][k]-yv*Q[k][j])
        er=numpy.dot(P,Q)
        print(er)
        e=0
        for i in range(1,len(R)):
            for j in range(1,len(R[i])):
                if R[i][j]>0:
                    e=(1/2)*pow(R[i][j]-numpy.dot(P[i,:],Q[:,j]),2)
                    for k in range(K):
                        e=e+(yu/2)*(pow(P[i][k],2))+(yv/2)*(pow(Q[k][j],2))
        if e<0.001:
            break
    return P,Q.T
def feature_matrix_factorization(R, F,P, Q,ToU, K, steps=1000, alpha=0.0002, yu=0.01, yv=0.01):
    Q=Q.T
    for step in range(steps):
        for i in range(1,len(R)):
            for j in range(1,len(R[i])):
                if R[i][j]>0:
                    eij = R[i][j] - numpy.dot(P[i, :], Q[:, j])-ToU[i][j]
                    for k in range(K):
                        #P[i][k] = P[i][k] + alpha * (2*eij * Q[k][j] - yu * P[i][k])
                        Q[k][j] = Q[k][j] + alpha * (2*eij * P[i][k] - yv * Q[k][j])
        e=0
        for i in range(1,len(R)):
            for j in range(1,len(R[i])):
                if R[i][j] > 0:
                    e = (1 / 2) * pow(R[i][j] - numpy.dot(P[i, :], Q[:, j] - ToU[i][j]), 2)
                    for k in range(K):
                        e = e + (yv / 2) * (pow(Q[k][j], 2))
        if e<0.001:
            break
    return Q.T

if __name__ == "__main__":


    dao=dao.dao()


    p = process.process()
    T,S=p.test_SdA()
    # T,S=p.tf_idf()
    print(T)
    print(S)
    numpy.save('T.npy',T)
    numpy.save('S.npy',S)


    N=201
    M=672


    K=len(T[0])
    R = numpy.zeros((N,M),dtype=float)
    F=numpy.zeros((N,M))
    traingings=dao.getTraining()
    for row in traingings:
        movieId=row[0]
        userId=row[1]
        R[movieId][userId]=row[2]
        F[movieId][userId]=1

    top = top.top(S, N, M)
    ToU = top.Caculate(traingings)
    print(ToU)

    P=numpy.row_stack(([0]*K,T))
    Q=numpy.random.rand(M,K)


    # nP, nQ=matrix_factorization(R,P, Q, K)
    # nR=numpy.dot(nP,nQ.T)
    # print(nR)
    nQ=feature_matrix_factorization(R, F,P, Q,ToU, K)
    print(nQ.shape)
    print(nQ)

    nQ=nQ.T

    Qualifying=dao.getQualifying()
    ratings=[]
    predictings=[]
    ToU_predictings=[]
    ToU_Qualifying=top.Caculate(Qualifying)
    numpy.save('ToU.npy', ToU_Qualifying)
    ToU_CF = numpy.zeros((N, M), dtype=float)
    for row in Qualifying:
        movieId=row[0]
        userId=row[1]
        r=numpy.dot(P[movieId, :], nQ[:, userId])+ToU_Qualifying[movieId][userId]
        ToU_predictings.append(ToU_Qualifying[movieId][userId])
        predictings.append(r)
        ratings.append(row[2])
        ToU_CF[movieId][userId]=r
    numpy.save('ToU_CF.npy',ToU_CF)
    predict_frame=pandas.DataFrame({'predicting':predictings,'ToU_predicting':ToU_predictings},index=Qualifying)
    print(predict_frame)
    SoP=0
    SoT=0
    for i in range(len(ratings)):
        SoP+=(ratings[i]-predictings[i])**2
        SoT+=(ratings[i]-ToU_predictings[i])**2
    SoP_erro=numpy.sqrt(SoP/len(ratings))
    SoT_erro=numpy.sqrt(SoT/len(ratings))

    print('SoP_erro:',SoP_erro)
    print()
    print('SoT_erro',SoT_erro)



                    