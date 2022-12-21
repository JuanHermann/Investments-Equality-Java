package com.juanstudy.investmentsequalityjava.Models;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "ComportamentoPapeis")
public class CompPapers implements Serializable {
    private List<Paper> paperList;

    public CompPapers(List<Paper> paperList) {
        this.paperList = paperList;
    }

    public CompPapers() {
    }

    public List<Paper> getPaperList() {
        return paperList;
    }

    @XmlElement(name = "Papel")
    public void setPaperList(List<Paper> paperList) {
        this.paperList = paperList;
    }
}
