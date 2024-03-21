package com.example.demo;



public class YourDataDTO {
    private String columnName;
    private String anotherColumn;
    private int numericColumn;
    private boolean booleanColumn;



    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getAnotherColumn() {
        return anotherColumn;
    }

    public void setAnotherColumn(String anotherColumn) {
        this.anotherColumn = anotherColumn;
    }

    public int getNumericColumn() {
        return numericColumn;
    }

    public void setNumericColumn(int numericColumn) {
        this.numericColumn = numericColumn;
    }

    public boolean isBooleanColumn() {
        return booleanColumn;
    }

    public void setBooleanColumn(boolean booleanColumn) {
        this.booleanColumn = booleanColumn;
    }


}
