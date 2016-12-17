package com.hm.birthday.master.blessing.vo;

public class BlessingVo {
	
	private Integer id;

    private String birthPerson;

    private String birthPersonPnum;

    private String blePerson;

    private String blePersonPnum;

    private String bleContent;

    private String createTime;

    
    
	public BlessingVo() {
		super();
	}

	public BlessingVo(Integer id, String birthPerson, String birthPersonPnum, String blePerson, String blePersonPnum,
			String bleContent, String createTime) {
		super();
		this.id = id;
		this.birthPerson = birthPerson;
		this.birthPersonPnum = birthPersonPnum;
		this.blePerson = blePerson;
		this.blePersonPnum = blePersonPnum;
		this.bleContent = bleContent;
		this.createTime = createTime;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBirthPerson() {
		return birthPerson;
	}

	public void setBirthPerson(String birthPerson) {
		this.birthPerson = birthPerson;
	}

	public String getBirthPersonPnum() {
		return birthPersonPnum;
	}

	public void setBirthPersonPnum(String birthPersonPnum) {
		this.birthPersonPnum = birthPersonPnum;
	}

	public String getBlePerson() {
		return blePerson;
	}

	public void setBlePerson(String blePerson) {
		this.blePerson = blePerson;
	}

	public String getBlePersonPnum() {
		return blePersonPnum;
	}

	public void setBlePersonPnum(String blePersonPnum) {
		this.blePersonPnum = blePersonPnum;
	}

	public String getBleContent() {
		return bleContent;
	}

	public void setBleContent(String bleContent) {
		this.bleContent = bleContent;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
}
