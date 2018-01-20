package com.KRJS.DAOImpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.KRJS.DAO.MemberDAO;
import com.KRJS.model.Member;
import com.KRJS.model.MemberDetails;


@Repository("memberdao")
@Transactional
public class MemberDAOImpl implements MemberDAO {

	@Autowired
	SessionFactory sessionFactory;

	
	

	/*
	 * static { sessionFactory = HibernateUtil.getSessionFactory(); }
	 */
	@Override
	
	public void insertMember(Member mem) {
		/*Session session = sessionFactory.openSession();
		try {

			Transaction t;
			t = session.beginTransaction();
			// session.getTransaction().begin();

			session.save(mem);
			t.rollback();
			session.flush();
			System.out.println("before commiteing");
			t.commit();

			System.out.println("Insert Operation success..........");
			
		} catch (Exception e) {
			System.out.println("rolled back");
			e.printStackTrace();
			if(session.getTransaction().isActive()) {
				System.out.println("Active");
				session.getTransaction().rollback();
			}
			else
				System.out.println("In Active");
			
			
						
		} */
		
		
	}




	@Override
	public Member getMember(String memberId) {
		// TODO Auto-generated method stub
		return null;
	}




	@Override
	public void updateMember(String memberId) {
		// TODO Auto-generated method stub
		
	}




	@Override
	public void deleteMember(String memId) {
		// TODO Auto-generated method stub
		
	}




	@Override
	public List<Member> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}




	@Override
	public List<Member> searchByDistrict(String district) {
		// TODO Auto-generated method stub
		return null;
	}




	@Override
	public List<Member> searchByTaluk(String taluk) {
		// TODO Auto-generated method stub
		return null;
	}




	@Override
	public List<Member> searchByPincode(int pincode) {
		// TODO Auto-generated method stub
		return null;
	}




	@Override
	public List<MemberDetails> searchByMobileNo(long phone) {
		// TODO Auto-generated method stub
		return null;
	}




	@Override
	public Member searchByApplicatioNo(int appno) {
		// TODO Auto-generated method stub
		return null;
	}

	/*@Override
	public Member getMember(String memberId) {

		session = sessionFactory.openSession();
		try {

			session.beginTransaction();
			Member member = (Member) session.get(Member.class, memberId);
			if (member != null) {
				return member;
			} else
				System.out.println("member doesnot Exist");
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			session.close();
		}

		return null;

	}

	@Override
	public void updateMember(String memberId) {

		session = sessionFactory.openSession();
		try {
			Transaction t = session.beginTransaction();
			Member member = (Member) session.get(Member.class, memberId);
			if (member != null) {
				System.out.println(member.getMemberId());

				member.setAppNo("148");
				session.saveOrUpdate(member);
				// insertMember(member);
				session.flush();
				session.getTransaction().commit();
				System.out.println("updated");
			} else {
				System.out.println("no member found");
			}
		} catch (Exception e) {
			e.printStackTrace();
			// t.rollback();
			System.out.println("rolled bacj");
		} finally {
			session.close();
		}

	}

	@Override
	public void deleteMember(String memberId) {

		session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			Member member = (Member) session.get(Member.class, memberId);
			if (member != null) {
				session.delete(member);
				session.getTransaction().commit();
				System.out.println("member deleted");
			} else {
				System.out.println("Member doesnot exist");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	@Override
	public List<Member> selectAll() {
		List<Member> list = new ArrayList<>();
		session = sessionFactory.openSession();
		try {
			// session.beginTransaction();
			list = session.createQuery("from Member").list();
			System.out.println(list.size());

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Member> searchByDistrict(String district) {
		try {
			List<Member> list = new ArrayList<>();
			session = sessionFactory.openSession();
			//CriteriaBuilder builder = session.getCriteriaBuilder();
			
			CriteriaQuery<Address> query = builder.createQuery(Address.class);
			Root<Address> root = query.from(Address.class);
			query.select(root);
			query.where(builder.equal(root.get("district"), district));
			
			list = ((List<Member>) session.createNativeQuery("select * from member where current_district = :district")
															.addEntity(Member.class).setParameter("district", district).list());
			
			
			CriteriaQuery<Member> query = builder.createQuery(Member.class);
			Root<Member> root = query.from(Member.class);
			query.select(root);
			query.where(builder.equal(root.get("current_district"), district));
			list = session.createQuery(query).list();
			System.out.println("success");
			return list;
			
		} catch (HibernateException e) {
			System.out.println("error");
			e.printStackTrace();
			return null;
		} finally {
			session.close();
		}
		
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Member> searchByTaluk(String taluk) {
		try {
			List<Member> list = new ArrayList<>();
			session = sessionFactory.openSession();
			list = (List<Member>) session.createNativeQuery("select * from member where current_taluk = :district")
					.addEntity(Member.class).setParameter("district", taluk).list();
			System.out.println("success");
			return list;
		} catch (HibernateException e) {
			System.out.println("error");
			e.printStackTrace();
			return null;
		} finally {
			session.close();
		}
	}

	@Override
	public List<Member> searchByPincode(int pincode) {
		try {
			List<Member> list = new ArrayList<>();
			session = sessionFactory.openSession();
			list = (List<Member>) session.createNativeQuery("select * from member where current_pincode = :district")
					.addEntity(Member.class).setParameter("district", pincode).list();
			System.out.println("success");
			return list;
		} catch (HibernateException e) {
			System.out.println("error");
			e.printStackTrace();
			return null;
		} finally {
			session.close();
		}
	}

	@Override
	public List<MemberDetails> searchByMobileNo(long phone) {
		try {
			List<MemberDetails> list = new ArrayList<>();
			session = sessionFactory.openSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		
		CriteriaQuery<MemberDetails> query = builder.createQuery(MemberDetails.class);
		Root<MemberDetails> root = query.from(MemberDetails.class);
		query.select(root);
		query.where(builder.equal(root.get("phone"), phone));
		list = session.createQuery(query).list();
		System.out.println("successs");
		return list;
		}  catch (HibernateException e) {
			System.out.println("error");
			e.printStackTrace();
			return null;
		} finally {
			session.close();
		}
	}

	@Override
	public Member searchByApplicatioNo(int appno) {
		
		return null;
	}
*/
}
