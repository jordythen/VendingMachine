//package com.revature.data;
//
//import static org.junit.Assert.assertTrue;
//
//import java.util.List;
//
//import org.junit.Test;
//
//import com.revature.beans.user.Review;
//
//public class ReviewHibernateTest {
//	static ReviewHibernate rh = new ReviewHibernate();
//	static int id;
//	
//	@Test
//	public void getByIdTest()
//	{
//		Review r = rh.getById(1);
//		System.out.println("review is " + r);
//		assertTrue(r.getStarRating() == 5);
//	}
//	
//	@Test
//	public void getAllTest()
//	{
//		List<Review> r = rh.getAll();
//		System.out.println(r);
//		assertTrue(r.size()>=1);
//	}
//	
//	@Test
//	public void addTest()
//	{
//		Review r = new Review();
//		r.setReviewTime(null);
//		r.setComments("These are comments");
//		r.setStarRating(5);
//		r.setId(rh.add(r));
//		System.out.println("THIS IS THE ID OF CREATED REVIEW" + r.getId());
//		Review r2 = rh.getById(r.getId());
//		assertTrue(r2.getComments().contains("These are comments")); 
//	}
//}
