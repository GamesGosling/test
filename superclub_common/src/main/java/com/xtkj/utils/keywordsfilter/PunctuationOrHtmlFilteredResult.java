package com.xtkj.utils.keywordsfilter;

import java.util.ArrayList;

public class PunctuationOrHtmlFilteredResult {

	private String originalString;
	private StringBuffer filteredString;
	private ArrayList<Integer> charOffsets;

	public String getOriginalString(){
		return this.originalString;
	}
	
	public void setOriginalString(String originalString) {
		this.originalString = originalString;
	}
	
	public StringBuffer getFilteredString() {
		return this.filteredString;
	}
	
	public void setFilteredString(StringBuffer filteredString) {
		this.filteredString = filteredString;
	}
	
	public ArrayList<Integer> getCharOffsets() {
		return this.charOffsets;
	}
	
	public void setCharOffsets(ArrayList<Integer> charOffsets) {
		this.charOffsets = charOffsets;
	}
}
