package com.ey.poc.VO;

import java.util.ArrayList;
import java.util.List;

import com.ey.poc.entity.RmtIntwQuestions;

public class QuestionsVO {
	private Long id;
	private Long subTopicId;
	public Long getLevelId() {
		return levelId;
	}

	public void setLevelId(Long levelId) {
		this.levelId = levelId;
	}
	private String subTopicName;
	private String question;
	private List<String> choices;
	private Long levelId;
	
	private String selectedAnswer;
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	public Long getSubTopicId() {
		return subTopicId;
	}
	public void setSubTopicId(Long subTopicId) {
		this.subTopicId = subTopicId;
	}
	public String getSubTopicName() {
		return subTopicName;
	}
	public void setSubTopicName(String subTopicName) {
		this.subTopicName = subTopicName;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	
	
	public String getSelectedAnswer() {
		return selectedAnswer;
	}
	public void setSelectedAnswer(String selectedAnswer) {
		this.selectedAnswer = selectedAnswer;
	}
	public Boolean getIsactive() {
		return isactive;
	}
	public void setIsactive(Boolean isactive) {
		this.isactive = isactive;
	}
	private Boolean isactive;
	public QuestionsVO(RmtIntwQuestions entity) {
		super();
		this.id = entity.getQuestion_id();
		this.subTopicId = entity.getRmtCompetencySubTopics().getSubTopicId();
		
		this.subTopicName = entity.getRmtCompetencySubTopics().getSubTopicName();
		this.question = entity.getQuestion();
		this.choices=new ArrayList<String>();
		if(entity.getChoice1()!=null&&!entity.getChoice1().equals("")) {
			this.choices.add(entity.getChoice1());
		}
		if(entity.getChoice2()!=null&&!entity.getChoice2().equals("")) {
			this.choices.add(entity.getChoice2());
		}
		if(entity.getChoice3()!=null&&!entity.getChoice3().equals("")) {
			this.choices.add(entity.getChoice3());
		}
		if(entity.getChoice4()!=null&&!entity.getChoice4().equals("")) {
			this.choices.add(entity.getChoice4());
		}
		if(entity.getChoice5()!=null&&!entity.getChoice5().equals("")) {
			this.choices.add(entity.getChoice5());
		}
		this.selectedAnswer = "";
		this.isactive = entity.getIsactive();
	}
	public List<String> getChoices() {
		return choices;
	}
	public void setChoices(List<String> choices) {
		this.choices = choices;
	}
	public QuestionsVO() {
		
	}
	public QuestionsVO(Long id, Long subTopicId, String subTopicName, String question, List<String> choices,
			String selectedAnswer, Boolean isactive) {
		super();
		this.id = id;
		this.subTopicId = subTopicId;
		this.subTopicName = subTopicName;
		this.question = question;
		this.choices = choices;
		this.selectedAnswer = selectedAnswer;
		this.isactive = isactive;
	}

}
