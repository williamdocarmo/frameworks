package com.app.dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.app.vo.Subscriber;

@Component
public class SubscriberDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public int createSubscriber(Subscriber subscriber) {
		String query = "insert into Subscriber values (?, ?, ?, ?, ?, ?, ?, ?)";
		return jdbcTemplate.update(query, subscriber.getMsisdn(), subscriber.getImsi(), subscriber.getVoice2G(), subscriber.getVolte(), subscriber.getSms(), subscriber.getMms(), subscriber.getDataGprs(), subscriber.getDataLte());
	}
	
	public List<Subscriber> getSubscriberByMSISDN(String msisdn) {
		System.out.println("MSISDN: "+msisdn);
		String query = "select * from subscriber where msisdn= ?";
		List<Subscriber> subscriberList = jdbcTemplate.query(query, new SubscriberMapper(), msisdn);
		System.out.println("subscriberList: "+subscriberList);
		return subscriberList;
	}
	
	public List<Subscriber> getSubscriberByIMSI(String imsi) {
		String query = "select * from subscriber where imsi= ?";
		List<Subscriber> subscriberList = jdbcTemplate.query(query, new SubscriberMapper(), imsi);
		System.out.println("subscriberList: "+subscriberList);
		return subscriberList;
	}
	
	public List<Map<String, Object>> getAllSubscriber() {
		String query = "select * from subscriber";
		return jdbcTemplate.queryForList(query);
	}
	
	public int updateSubscriber(String msisdn, String voice2G, String volte, String sms, String mms, String dataGprs, String dataLte) {
		String query = "update subscriber set voice2G=?, voiceLTE=?, sms=?, mms=?, gprs=?, lte=? where msisdn=?";
		return jdbcTemplate.update(query, voice2G, volte, sms, mms, dataGprs, dataLte, msisdn);
	}
	
	public int deleteSubscriber(String msisdn) {
		String query = "delete from subscriber where msisdn = ?";
		return jdbcTemplate.update(query, msisdn);
	}
	
	
	
	private class SubscriberMapper implements RowMapper<Subscriber>{
		@Override
		public Subscriber mapRow(ResultSet rs, int rowNum) throws SQLException {
			Subscriber subscriber = new Subscriber();
			subscriber.setMsisdn(rs.getString("msisdn"));
			subscriber.setImsi(rs.getString("imsi"));
			subscriber.setVoice2G(rs.getString("voice2G"));
			subscriber.setVolte(rs.getString("voiceLTE"));
			subscriber.setSms(rs.getString("SMS"));
			subscriber.setMms(rs.getString("MMS"));
			subscriber.setDataGprs(rs.getString("GPRS"));
			subscriber.setDataLte(rs.getString("LTE"));
			return subscriber;
		}
	}
	
}


