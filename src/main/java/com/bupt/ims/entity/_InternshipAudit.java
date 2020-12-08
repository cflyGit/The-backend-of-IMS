package com.bupt.ims.entity;

import java.io.Serializable;

public class _InternshipAudit implements Serializable {
    private long order;
    // 0： 未审批， 1：以通过， 2： 未通过
    private int baseAudit;
    // 0: 未签署， 1： 已签署
    private int studentQuartetAgreement;
    private int baseQuartetAgreement;
    private int tutor1QuartetAgreement;
    private int tutor2QuartetAgreement;
    // 0: 未备案， 1：已备案
    private int record;

    public _InternshipAudit(Project p, ItemList il, String s) {
    }

    public long getOrder() {
        return order;
    }

    public void setOrder(long order) {
        this.order = order;
    }

    public int getBaseAudit() {
        return baseAudit;
    }

    public void setBaseAudit(int baseAudit) {
        this.baseAudit = baseAudit;
    }

    public int getStudentQuartetAgreement() {
        return studentQuartetAgreement;
    }

    public void setStudentQuartetAgreement(int studentQuartetAgreement) {
        this.studentQuartetAgreement = studentQuartetAgreement;
    }

    public int getBaseQuartetAgreement() {
        return baseQuartetAgreement;
    }

    public void setBaseQuartetAgreement(int baseQuartetAgreement) {
        this.baseQuartetAgreement = baseQuartetAgreement;
    }

    public int getTutor1QuartetAgreement() {
        return tutor1QuartetAgreement;
    }

    public void setTutor1QuartetAgreement(int tutor1QuartetAgreement) {
        this.tutor1QuartetAgreement = tutor1QuartetAgreement;
    }

    public int getTutor2QuartetAgreement() {
        return tutor2QuartetAgreement;
    }

    public void setTutor2QuartetAgreement(int tutor2QuartetAgreement) {
        this.tutor2QuartetAgreement = tutor2QuartetAgreement;
    }

    public int getRecord() {
        return record;
    }

    public void setRecord(int record) {
        this.record = record;
    }

    @Override
    public String toString() {
        return "InternshipAudit{" +
                "order=" + order +
                ", baseAudit=" + baseAudit +
                ", studentQuartetAgreement=" + studentQuartetAgreement +
                ", baseQuartetAgreement=" + baseQuartetAgreement +
                ", tutor1QuartetAgreement=" + tutor1QuartetAgreement +
                ", tutor2QuartetAgreement=" + tutor2QuartetAgreement +
                ", record=" + record +
                '}';
    }
}

