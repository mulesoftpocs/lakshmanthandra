package com.Spring.FileDB;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "myfiles")
@ApiModel(description= "These fileds are related to upload and download REST api")
public class UploadDownloadModel {
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@ApiModelProperty(notes = "This field is for unique identification")
	private String id;
	@ApiModelProperty(notes = "This field is to define the name of the product")
	private String name;
	@ApiModelProperty(notes = "This field is to define the type of the product")
	private String type;

	@Lob
	private byte[] data;

	public UploadDownloadModel() {
	}

	public UploadDownloadModel(String name, String type, byte[] data) {
		this.name = name;
		this.type = type;
		this.data = data;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}



}
