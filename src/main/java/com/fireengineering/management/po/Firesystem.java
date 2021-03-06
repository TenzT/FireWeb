package com.fireengineering.management.po;

public class Firesystem {
    private Integer id;

    private String name;

    private String note;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }

    @Override
    public String toString() {
        return "Firesystem{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", note='" + note + '\'' +
                '}';
    }
}