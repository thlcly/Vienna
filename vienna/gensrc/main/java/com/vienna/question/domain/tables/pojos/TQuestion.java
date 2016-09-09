/**
 * This class is generated by jOOQ
 */
package com.vienna.question.domain.tables.pojos;


import java.io.Serializable;

import javax.annotation.Generated;

import org.joda.time.DateTime;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.8.4"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class TQuestion implements Serializable {

    private static final long serialVersionUID = 737792262;

    private Integer  id;
    private Integer  typeId;
    private Integer  userId;
    private String   question;
    private String   solved;
    private String   refrerence;
    private DateTime created;
    private DateTime updated;
    private Boolean  status;

    public TQuestion() {}

    public TQuestion(TQuestion value) {
        this.id = value.id;
        this.typeId = value.typeId;
        this.userId = value.userId;
        this.question = value.question;
        this.solved = value.solved;
        this.refrerence = value.refrerence;
        this.created = value.created;
        this.updated = value.updated;
        this.status = value.status;
    }

    public TQuestion(
        Integer  id,
        Integer  typeId,
        Integer  userId,
        String   question,
        String   solved,
        String   refrerence,
        DateTime created,
        DateTime updated,
        Boolean  status
    ) {
        this.id = id;
        this.typeId = typeId;
        this.userId = userId;
        this.question = question;
        this.solved = solved;
        this.refrerence = refrerence;
        this.created = created;
        this.updated = updated;
        this.status = status;
    }

    public Integer getId() {
        return this.id;
    }

    public TQuestion setId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getTypeId() {
        return this.typeId;
    }

    public TQuestion setTypeId(Integer typeId) {
        this.typeId = typeId;
        return this;
    }

    public Integer getUserId() {
        return this.userId;
    }

    public TQuestion setUserId(Integer userId) {
        this.userId = userId;
        return this;
    }

    public String getQuestion() {
        return this.question;
    }

    public TQuestion setQuestion(String question) {
        this.question = question;
        return this;
    }

    public String getSolved() {
        return this.solved;
    }

    public TQuestion setSolved(String solved) {
        this.solved = solved;
        return this;
    }

    public String getRefrerence() {
        return this.refrerence;
    }

    public TQuestion setRefrerence(String refrerence) {
        this.refrerence = refrerence;
        return this;
    }

    public DateTime getCreated() {
        return this.created;
    }

    public TQuestion setCreated(DateTime created) {
        this.created = created;
        return this;
    }

    public DateTime getUpdated() {
        return this.updated;
    }

    public TQuestion setUpdated(DateTime updated) {
        this.updated = updated;
        return this;
    }

    public Boolean getStatus() {
        return this.status;
    }

    public TQuestion setStatus(Boolean status) {
        this.status = status;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("TQuestion (");

        sb.append(id);
        sb.append(", ").append(typeId);
        sb.append(", ").append(userId);
        sb.append(", ").append(question);
        sb.append(", ").append(solved);
        sb.append(", ").append(refrerence);
        sb.append(", ").append(created);
        sb.append(", ").append(updated);
        sb.append(", ").append(status);

        sb.append(")");
        return sb.toString();
    }
}
