package esc;

/**
 * ��Ʒ��ҵ���߼���
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

	// 1.��ȡ���ݿ�����
	public static Connection getConnect() {

		// 1.��ȡ���ݿ�����
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.print("������������");
			e.printStackTrace();
		}

		String url = "jdbc:mysql://localhost:3306/15rj_db09";

		Connection conn = null;

		try {
			conn = (Connection) DriverManager.getConnection(url, "root",
					"111111");
		} catch (SQLException e) {
			System.out.print("���ݿ����Ӵ���");
			e.printStackTrace();
		}

		return conn;

	}

	public static List<qclb> getQclb() throws SQLException {

		// ��ȡ���ݿ�����
		Connection conn = QcService.getConnect();

		// ʵ����QueryRunner����
		QueryRunner qr = new QueryRunner();

		// update,query
		String sql = "select * from qclb ";

		List<qclb> list = qr.query(conn, sql, new BeanListHandler(qclb.class));

		// �ͷ���Դ
		DbUtils.closeQuietly(conn);

		return list;

	}

	public static List<qc> getQc() throws SQLException {

		// ��ȡ���ݿ�����
		Connection conn = QcService.getConnect();

		// ʵ����QueryRunner����
		QueryRunner qr = new QueryRunner();

		// update,query
		String sql = "select * from qc ";

		List<qc> spList = qr.query(conn, sql, new BeanListHandler(qc.class));

		// �ͷ���Դ
		DbUtils.closeQuietly(conn);

		return spList;

	}

	public static List<qc> getQc(int lbid) throws SQLException {

		// ��ȡ���ݿ�����
		Connection conn = QcService.getConnect();

		// ʵ����QueryRunner����
		QueryRunner qr = new QueryRunner();

		// update,query
		String sql = "select * from qc where qclb=?";

		List<qc> spList = qr.query(conn, sql, new BeanListHandler(qc.class),
				lbid);

		// �ͷ���Դ
		DbUtils.closeQuietly(conn);

		return spList;

	}

	public static qc getQcById(int qcid) throws SQLException {

		// ��ȡ���ݿ�����
		Connection conn = QcService.getConnect();

		// ʵ����QueryRunner����
		QueryRunner qr = new QueryRunner();

		// update,query
		String sql = "select * from qc where qcid=?";

		qc qc = qr.query(conn, sql, new BeanHandler(qc.class), qcid);

		// �ͷ���Դ
		DbUtils.closeQuietly(conn);

		return qc;

	}

	public static Custom Login(String name, String pwd) {

		// ��ȡ���ݿ�����
		Connection conn = null;

		Custom custom = null;
		try {
			// ʵ����QueryRunner����
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

		// �ͷ���Դ
		DbUtils.closeQuietly(conn);

		return custom;

	}

	public static void add(String name, int qcid) {

		// ��ȡ���ݿ�����
		Connection conn = QcService.getConnect();

		// ʵ����QueryRunner����
		QueryRunner qr = new QueryRunner();

		// update,query
		String sql = "insert into love(name,qcid)values(?,?)";
		try {
			qr.update(conn, sql, name, qcid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// �ͷ���Դ
		DbUtils.closeQuietly(conn);

	}

	public static Boolean Register(String name, String pwd,
			String phone, String location) {

		// ��ȡ���ݿ�����
		Connection conn = null;
		Boolean f=false;
		int d = 0 ;
		try {
			// ʵ����QueryRunner����
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

		// �ͷ���Դ
		DbUtils.closeQuietly(conn);

		return f;

	}

	public static List<Love> get(String name) {
		// ��ȡ����
		Connection conn = QcService.getConnect();

		// ʵ����QueryRunner����
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
		// �ͷ���Դ
		DbUtils.closeQuietly(conn);
		return List;
	}

	public static void delete(int qcid,String name)  {
		// ��ȡ����
		Connection conn = QcService.getConnect();

		// ʵ����QueryRunner����
		QueryRunner qr = new QueryRunner();

		// update,query

		String sql = "delete from love where qcid = ? and name=?";

		try {
			qr.update(conn, sql, qcid,name);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// �ͷ���Դ
		DbUtils.closeQuietly(conn);
	}

	/**
	 * ��ȡ�û��ղص�����
	 * 
	 * @return
	 * @throws SQLException
	 */
	public static long getLoveTotal(String name)  {

		// ��ȡ���ݿ�����
		Connection conn = QcService.getConnect();

		// ʵ����QueryRunner����
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

		// �ͷ���Դ
		DbUtils.closeQuietly(conn);

		return map.get("count");

	}
	public static List<qc> qcQuery(String key) throws SQLException {

		// ��ȡ���ݿ�����
		Connection conn = QcService.getConnect();

		// ʵ����QueryRunner����
		QueryRunner qr = new QueryRunner();

		key = "%" + key + "%";
		// update,query
		String sql = "select * ,count(*) as count from qc where qcmc like ?";

		List<qc> list = qr.query(conn, sql, new BeanListHandler(qc.class), key);

		// �ͷ���Դ
		DbUtils.closeQuietly(conn);

		return list;

	}
	public static List<qc> jgQuery(int qcjgmin,int qcjgmax) throws SQLException {

		// ��ȡ���ݿ�����
		Connection conn = QcService.getConnect();

		// ʵ����QueryRunner����
		QueryRunner qr = new QueryRunner();

		;// update,query
		String sql = "select * from qc where  qcjg>=? and qcjg<=? ";

		List<qc> list = qr.query(conn, sql, new BeanListHandler(qc.class), qcjgmin,qcjgmax);

		// �ͷ���Դ
		DbUtils.closeQuietly(conn);

		return list;

	}

	public static List<qc> getQc(int pageNo, int pageSize) {
		// ��ȡ���ݿ�����
					Connection conn = QcService.getConnect();

					// ʵ����QueryRunner����
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

					// �ͷ���Դ
					DbUtils.closeQuietly(conn);

					return list;
		// TODO Auto-generated method stub
		
	}

	public static long getQcTotal() {
		// ��ȡ���ݿ�����
					Connection conn = QcService.getConnect();

					// ʵ����QueryRunner����
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

					
					
					// �ͷ���Դ
					DbUtils.closeQuietly(conn);

					return map.get("count");
		// TODO Auto-generated method stub
		
	}

	public static long getQcTotal( int lbid) {
		// ��ȡ���ݿ�����
					Connection conn = QcService.getConnect();

					// ʵ����QueryRunner����
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

					
					
					// �ͷ���Դ
					DbUtils.closeQuietly(conn);

					return map.get("count");
		// TODO Auto-generated method stub
		
	}

	public static List<qc> getQc(int lbid, int pageNo, int pageSize) {
		// ��ȡ���ݿ�����
					Connection conn = QcService.getConnect();

					// ʵ����QueryRunner����
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

					// �ͷ���Դ
					DbUtils.closeQuietly(conn);

					return list;
	}
	public static long getQcLoveTotal(int qcid)  {

		// ��ȡ���ݿ�����
		Connection conn = QcService.getConnect();

		// ʵ����QueryRunner����
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

		// �ͷ���Դ
		DbUtils.closeQuietly(conn);

		return map.get("count");

	}
	public static boolean isLove(String qcid,String name)  {

		// ��ȡ���ݿ�����
		Connection conn = QcService.getConnect();

		// ʵ����QueryRunner����
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

		// �ͷ���Դ
		DbUtils.closeQuietly(conn);

		return map.get("count")==1;

	}
	public static List<qcCount> csQuery() throws SQLException {

		// ��ȡ���ݿ�����
		Connection conn = QcService.getConnect();

		// ʵ����QueryRunner����
		QueryRunner qr = new QueryRunner();

		// update,query
		String sql = "select qctp,qcmc ,sl from qc right join (select qc.qcid,count(love.name)as sl from love,qc where love.qcid=qc.qcid GROUP by love.qcid ) l on qc.qcid=l.qcid order by sl desc";

		List<qcCount> list = qr.query(conn, sql, new BeanListHandler(
				qcCount.class));

		// �ͷ���Դ
		DbUtils.closeQuietly(conn);

		return list;

	}
}
