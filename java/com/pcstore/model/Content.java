package com.pcstore.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
	public class Content {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "content_seq")
	@SequenceGenerator(name = "content_seq", sequenceName = "content_seq", allocationSize = 1)
	private Long id;

	    private String page;
	    private String section;
	    private String content;
		public String getPage() {
			return page;
		}
		public void setPage(String page) {
			this.page = page;
		}
		public String getSection() {
			return section;
		}
		public void setSection(String section) {
			this.section = section;
		}
		public String getContent() {
			return content;
		}
		public void setContent(String content) {
			this.content = content;
		}
		
	}
