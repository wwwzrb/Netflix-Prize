import pandas as pd
import numpy as np
import dao
dao=dao.dao()
print(dao.M)
print(dao.N)
trainings=dao.getTraining()
message="Hello world!"
print(message)
message="Test"
print(message)
titles=['zero','one','two','three','four']
clusters=['1','2','3','4','5']
films={'title':titles,'cluster':clusters}
frame=pd.DataFrame(films,columns=['title','cluster'])
print(frame.ix[1]['title'])

R = [
    [5, 3, 0, 1],
    [4, 0, 0, 1],
    [1, 1, 0, 5],
    [1, 0, 0, 4],
    [0, 1, 5, 4],
]
print(len(R))
R=np.array(R)
print(R.shape)


M=9000
K=600
Q = np.zeros((K,M))
print(len(Q))
for i in range(1,3):
    print(i)

a=[1]*100000
print(len(a))

rng = np.random.RandomState(123)
print(rng.randn(10, 2))


