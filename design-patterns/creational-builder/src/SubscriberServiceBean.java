
public class SubscriberServiceBean {

	public static class Builder {

		private String voice;

		private String sms;

		private String lteData;

		private String gprs;

		public Builder() {
		}

		public Builder voice(String voice) {
			this.voice = voice;
			return this;
		}

		public Builder sms(String sms) {
			this.sms = sms;
			return this;
		}

		public Builder lteData(String lteData) {
			this.lteData = lteData;
			return this;
		}

		public Builder gprs(String gprs) {
			this.gprs = gprs;
			return this;
		}

		public SubscriberServiceBean build() {
			return new SubscriberServiceBean(this);
		}
	}

	private SubscriberServiceBean(Builder builder) {
		this.voice = builder.voice;
		this.sms = builder.sms;
		this.lteData = builder.lteData;
		this.gprs = builder.gprs;
	}

	private String voice;

	private String sms;

	private String lteData;

	private String gprs;

	public String getVoice() {
		return voice;
	}

	public String getSms() {
		return sms;
	}

	public String getLteData() {
		return lteData;
	}

	public String getGprs() {
		return gprs;
	}

	@Override
	public String toString() {
		return "SubscriberServiceBean [voice=" + voice + ", sms=" + sms + ", lteData=" + lteData + ", gprs=" + gprs
				+ "]";
	}

}
