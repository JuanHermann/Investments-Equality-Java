package com.juanstudy.investmentsequalityjava.Models;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.io.Serializable;
import java.util.List;

@Root(name = "ComportamentoPapeis")
public class CompPapers implements Serializable {

    @ElementList(inline = true, name = "Papel")
    private List<Paper> paperList;

    public CompPapers(List<Paper> paperList) {
        this.paperList = paperList;
    }

    public CompPapers() {
    }

    public List<Paper> getPaperList() {
        return paperList;
    }

    public void setPaperList(List<Paper> paperList) {
        this.paperList = paperList;
    }
}
