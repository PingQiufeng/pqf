package esc;

/**
 * 商品的业务逻辑类
 * @author Administrator
 *
 */

import java.util.List;
import java.util.Map;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapHandler;

import com.mysql.jdbc.Connection;



public class QcService {

	// 1.获取数据库连接
	public static Connection getConnect() {

		// 1.获取数据库连接
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.print("加载驱动错误！");
			e.printStackTrace();
		}

		String url = "jdbc:mysql://localhost:3306/15rj_db09";

		Connection conn = null;

		try {
			conn = (Connection) DriverManager.getConnection(url, "root",
					"111111");
		} catch (SQLException e) {
			System.out.print("数据库连接错误！");
			e.printStackTrace();
		}

		return conn;

	}

	public static List<qclb> getQclb() throws SQLException {

		// 获取数据库连接
		Connection conn = QcService.getConnect();

		// 实例化QueryRunner对象
		QueryRunner qr = new QueryRunner();

		// update,query
		String sql = "select * from qclb ";

		List<qclb> list = qr.query(conn, sql, new BeanListHandler(qclb.class));

		// 释放资源
		DbUtils.closeQuietly(conn);

		return list;

	}

	public static List<qc> getQc() throws SQLException {

		// 获取数据库连接
		Connection conn = QcService.getConnect();

		// 实例化QueryRunner对象
		QueryRunner qr = new QueryRunner();

		// update,query
		String sql = "select * from qc ";

		List<qc> spList = qr.query(conn, sql, new BeanListHandler(qc.class));

		// 释放资源
		DbUtils.closeQuietly(conn);

		return spList;

	}

	public static List<qc> getQc(int lbid) throws SQLException {

		// 获取数据库连接
		Connection conn = QcService.getConnect();

		// 实例化QueryRunner对象
		QueryRunner qr = new QueryRunner();

		// update,query
		String sql = "select * from qc where qclb=?";

		List<qc> spList = qr.query(conn, sql, new BeanListHandler(qc.class),
				lbid);

		// 释放资源
		DbUtils.closeQuietly(conn);

		return spList;

	}

	public static qc getQcById(int qcid) throws SQLException {

		// 获取数据库连接
		Connection conn = QcService.getConnect();

		// 实例化QueryRunner对象
		QueryRunner qr = new QueryRunner();

		// update,query
		String sql = "select * from qc where qcid=?";

		qc qc = qr.query(conn, sql, new BeanHandler(qc.class), qcid);

		// 释放资源
		DbUtils.closeQuietly(conn);

		return qc;

	}

	public static Custom Login(String name, String pwd) {

		// 获取数据库连接
		Connection conn = null;

		Custom custom = null;
		try {
			// 实例化QueryRunner对象
			QueryRunner qr = new QueryRunner();
			conn = QcService.getConnect();

			// update,query
			String sql = "select * from custom where name=? and pwd=?";
			custom = qr.query(conn, sql, new BeanHandler(Custom.class), name,
					pwd);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// 释放资源
		DbUtils.closeQuietly(conn);

		return custom;

	}

	public static void add(String name, int qcid) {

		// 获取数据库连接
		Connection conn = QcService.getConnect();

		// 实例化QueryRunner对象
		QueryRunner qr = new QueryRunner();

		// update,query
		String sql = "insert into love(name,qcid)values(?,?)";
		try {
			qr.update(conn, sql, name, qcid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// 释放资源
		DbUtils.closeQuietly(conn);

	}

	public static Boolean Register(String name, String pwd,
			String phone, String location) {

		// 获取数据库连接
		Connection conn = null;
		Boolean f=false;
		int d = 0 ;
		try {
			// 实例化QueryRunner对象
			QueryRunner qr = new QueryRunner();
			conn = QcService.getConnect();

			// update,query
			String sql = "insert into custom(name,pwd,phone,location)values(?,?,?,?)";
			qr.update(conn, sql, name, pwd, phone, location);
			f=true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			f=false;
		}

		// 释放资源
		DbUtils.closeQuietly(conn);

		return f;

	}

	public static List<Love> get(String name) {
		// 获取连接
		Connection conn = QcService.getConnect();

		// 实例化QueryRunner对象
		QueryRunner qr = new QueryRunner();

		// update,query
		String sql = "select l.id,l.qcid,q.qcmc,q.qctp,q.qcjg from love as l left join qc as q on l.qcid=q.qcid where name=?";

		List<Love> List = null;
		try {
			List = qr.query(conn, sql, new BeanListHandler(Love.class), name);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 释放资源
		DbUtils.closeQuietly(conn);
		return List;
	}

	public static void delete(int qcid,String name)  {
		// 获取连接
		Connection conn = QcService.getConnect();

		// 实例化QueryRunner对象
		QueryRunner qr = new QueryRunner();

		// update,query

		String sql = "delete from love where qcid = ? and name=?";

		try {
			qr.update(conn, sql, qcid,name);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 释放资源
		DbUtils.closeQuietly(conn);
	}

	/**
	 * 获取用户收藏的总数
	 * 
	 * @return
	 * @throws SQLException
	 */
	public static long getLoveTotal(String name)  {

		// 获取数据库连接
		Connection conn = QcService.getConnect();

		// 实例化QueryRunner对象
		QueryRunner qr = new QueryRunner();

		// update,query
		String sql = "select count(*) as count from love where name =?";
		
		Map<String, Long> map=null;
		try {
			map = (Map) qr.query(conn, sql, new MapHandler(),
					name);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// System.out.println("count:"+map.get("count"));

		// 释放资源
		DbUtils.closeQuietly(conn);

		return map.get("count");

	}
	public static List<qc> qcQuery(String key) throws SQLException {

		// 获取数据库连接
		Connection conn = QcService.getConnect();

		// 实例化QueryRunner对象
		QueryRunner qr = new QueryRunner();

		key = "%" + key + "%";
		// update,query
		String sql = "select * ,count(*) as count from qc where qcmc like ?";

		List<qc> list = qr.query(conn, sql, new BeanListHandler(qc.class), key);

		// 释放资源
		DbUtils.closeQuietly(conn);

		return list;

	}
	public static List<qc> jgQuery(int qcjgmin,int qcjgmax) throws SQLException {

		// 获取数据库连接
		Connection conn = QcService.getConnect();

		// 实例化QueryRunner对象
		QueryRunner qr = new QueryRunner();

		;// update,query
		String sql = "select * from qc where  qcjg>=? and qcjg<=? ";

		List<qc> list = qr.query(conn, sql, new BeanListHandler(qc.class), qcjgmin,qcjgmax);

		// 释放资源
		DbUtils.closeQuietly(conn);

		return list;

	}

	public static List<qc> getQc(int pageNo, int pageSize) {
		// 获取数据库连接
					Connection conn = QcService.getConnect();

					// 实例化QueryRunner对象
					QueryRunner qr = new QueryRunner();

					// update,query
					String sql = "select * from qc limit ?,?";

					List<qc> list=null;
					try {
						list = qr.query(conn, sql, new BeanListHandler(
								qc.class),(pageNo-1)*pageSize,pageSize);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					// 释放资源
					DbUtils.closeQuietly(conn);

					return list;
		// TODO Auto-generated method stub
		
	}

	public static long getQcTotal() {
		// 获取数据库连接
					Connection conn = QcService.getConnect();

					// 实例化QueryRunner对象
					QueryRunner qr = new QueryRunner();

					// update,query
					String sql = "select count(*) as count from qc";
				
					Map<String, Long> map =null;
					try {
						map = (Map)qr.query(conn, sql,new MapHandler());
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					
					
					// 释放资源
					DbUtils.closeQuietly(conn);

					return map.get("count");
		// TODO Auto-generated method stub
		
	}

	public static long getQcTotal( int lbid) {
		// 获取数据库连接
					Connection conn = QcService.getConnect();

					// 实例化QueryRunner对象
					QueryRunner qr = new QueryRunner();

					// update,query
					String sql = "select count(*) as count from qc where qclb=?";
					
					Map<String, Long> map=null;
					try {
						map = (Map)qr.query(conn, sql,new MapHandler(),lbid);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					
					
					// 释放资源
					DbUtils.closeQuietly(conn);

					return map.get("count");
		// TODO Auto-generated method stub
		
	}

	public static List<qc> getQc(int lbid, int pageNo, int pageSize) {
		// 获取数据库连接
					Connection conn = QcService.getConnect();

					// 实例化QueryRunner对象
					QueryRunner qr = new QueryRunner();

					// update,query
					String sql = "select * from qc where qclb=? limit ?,?";

					List<qc> list=null;
					try {
						list = qr.query(conn, sql, new BeanListHandler(
								qc.class),lbid,(pageNo-1)*pageSize,pageSize);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					// 释放资源
					DbUtils.closeQuietly(conn);

					return list;
	}
	public static long getQcLoveTotal(int qcid)  {

		// 获取数据库连接
		Connection conn = QcService.getConnect();

		// 实例化QueryRunner对象
		QueryRunner qr = new QueryRunner();

		// update,query
		String sql = "select count(*) as count from love where qcid =?";
		
		Map<String, Long> map=null;
		try {
			map = (Map) qr.query(conn, sql, new MapHandler(),
					qcid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// System.out.println("count:"+map.get("count"));

		// 释放资源
		DbUtils.closeQuietly(conn);

		return map.get("count");

	}
	public static boolean isLove(String qcid,String name)  {

		// 获取数据库连接
		Connection conn = QcService.getConnect();

		// 实例化QueryRunner对象
		QueryRunner qr = new QueryRunner();

		// update,query
		String sql = "select count(*) as count from love where qcid =? and name=?";
		
		Map<String, Long> map=null;
		try {
			map = (Map) qr.query(conn, sql, new MapHandler(),
					qcid,name);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// System.out.println("count:"+map.get("count"));

		// 释放资源
		DbUtils.closeQuietly(conn);

		return map.get("count")==1;

	}
	public static List<qcCount> csQuery() throws SQLException {

		// 获取数据库连接
		Connection conn = QcService.getConnect();

		// 实例化QueryRunner对象
		QueryRunner qr = new QueryRunner();

		// update,query
		String sql = "select qctp,qcmc ,sl from qc right join (select qc.qcid,count(love.name)as sl from love,qc where love.qcid=qc.qcid GROUP by love.qcid ) l on qc.qcid=l.qcid order by sl desc";

		List<qcCount> list = qr.query(conn, sql, new BeanListHandler(
				qcCount.class));

		// 释放资源
		DbUtils.closeQuietly(conn);

		return list;

	}
}
