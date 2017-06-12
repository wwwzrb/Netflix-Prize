import  dao
import numpy
dao=dao.dao()

'''
ToU=numpy.load('ToU.npy')
ToU_CF=numpy.load('ToU_CF.npy')
Qualifying=dao.getQualifying()
'''
movies=dao.getMovieId()
S=numpy.load('S.npy')
for i in range(len(S)):
    for j in range(i+1,len(S[i])):
        dao.insertSimilarity(movies[i][1],movies[j][1],S[i][j])
        print(movies[i][1],movies[j][1])


'''
for row in Qualifying:
    movieId = row[0]
    userId = row[1]
    id=row[3]
    print(movieId,userId,id)
    dao.updateRating(id,userId,ToU[movieId][userId],ToU_CF[movieId][userId])
'''

