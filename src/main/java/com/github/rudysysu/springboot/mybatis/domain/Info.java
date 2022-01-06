package com.github.rudysysu.springboot.mybatis.domain;

public class Info {
	private Long uid;
	private Long tid;

	public Long getUid() {
		return uid;
	}

	public void setUid(Long uid) {
		this.uid = uid;
	}

	public Long getTid() {
		return tid;
	}

	public void setTid(Long tid) {
		this.tid = tid;
	}

    @Override
    public String toString() {
        return "Info{" +
                "uid=" + uid +
                ", tid=" + tid +
                '}';
    }
}