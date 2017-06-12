import pymysql
pymysql.install_as_MySQLdb()
import MySQLdb as mdb
class dao():
    def __init__(self):
        config = {
            'host': 'localhost',
            'port': 3306,
            'user': 'root',
            'password': '2315',
            'db': 'movielens',
            'charset': 'utf8'
        }
        conn = mdb.connect(**config)
        self.conn=conn
        self.M=200
        self.N=50

    def getDocument(self):
        self.cursor = self.conn.cursor()
        sql = "select * from movie where id>=1 and id<='%d'" % self.M
        try:
            # 执行SQL语句
            self.cursor.execute(sql)
            # 获取所有记录列表
            results = self.cursor.fetchall()
            return results
        except:
            print("Error: unable to fecth data")

    def getMovieId(self):
        self.cursor = self.conn.cursor()
        sql = "select Id,MovieId from movie where id>=1 and id<='%d'" % self.M
        try:
            # 执行SQL语句
            self.cursor.execute(sql)
            # 获取所有记录列表
            results = self.cursor.fetchall()
            return results
        except:
            print("Error: unable to fecth data")

    def getTraining(self):
        self.cursor = self.conn.cursor()
        sql = "select m.id,t.userId,t.Rating from rating as t,movie as m where t.MovieId=m.MovieId and m.id>=1 and m.id<='%d' and m.MovieId not in (select m.MovieId from (select MovieId from movie where id>=1 and id<='%d' ORDER BY Date desc limit 0,20) as m)" % (self.M, self.M)
        try:
            # 执行SQL语句
            self.cursor.execute(sql)
            # 获取所有记录列表
            results = self.cursor.fetchall()
            return results
        except:
            print("Error: unable to fecth data")

    def getQualifying(self):
        self.cursor = self.conn.cursor()
        sql = "select m.id,t.userId,t.Rating,t.MovieId from rating as t,movie as m where t.MovieId=m.MovieId and m.id>=1 and m.id<='%d' and m.MovieId in (select m.MovieId from (select MovieId from movie where id>=1 and id<='%d' ORDER BY Date desc limit 0,20) as m)" % (self.M,self.M)
        try:
            # 执行SQL语句
            self.cursor.execute(sql)
            # 获取所有记录列表
            results = self.cursor.fetchall()
            return results
        except:
            print("Error: unable to fecth data")

    def getToURating(self,id,userId):
        self.cursor = self.conn.cursor()
        sql = "select m.id,t.userId,t.Rating from rating as t,movie as m where t.MovieId=m.MovieId and m.id!='%d' and m.id>=1 and m.id<='%d' and m.MovieId not in (select m.MovieId from (select MovieId from movie where id>=1 and id<='%d' ORDER BY Date desc limit 0,20) as m) and t.userId='%d'"% (id,self.M,self.M,userId)
        try:
            # 执行SQL语句
            self.cursor.execute(sql)
            # 获取所有记录列表
            results = self.cursor.fetchall()
            return results
        except:
            print("Error: unable to fecth data")

    def insertSimilarity(self,movieId,similarId,similarity):
        self.cursor = self.conn.cursor()
        sql = "insert into similarity(MovieId,SimilarId,Similarity) VALUES ('%d','%d','%f')" %(movieId,similarId,similarity)
        try:
            # 执行SQL语句
            self.cursor.execute(sql)
            # 获取所有记录列表
            self.conn.commit()
        except:
            self.conn.rollback()
            print("Error: unable to fecth data")

    def updateRating(self,movieId,userId,tou_rating,rating):
        self.cursor = self.conn.cursor()
        sql = "update rating set ToU='%f',ToUCF='%f' where movieId='%d' and userId='%d'"%(tou_rating,rating,movieId,userId)
        try:
            # 执行SQL语句
            self.cursor.execute(sql)
            # 获取所有记录列表
            self.conn.commit()
        except:
            self.conn.rollback()
            print("Error: unable to fecth data")

    def _close_(self):
        # 关闭数据库连接
        self.conn.close()
