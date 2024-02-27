package Entity;

import java.util.Date;

public class ToDoEntity {
    private String name;

    private String description;

    private Date planStart;


    private Date planEnd;


    private int status;

    private int id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getPlanStart() {
        return planStart;
    }

    public void setPlanStart(Date planStart) {
        this.planStart = planStart;
    }

    public Date getPlanEnd() {
        return planEnd;
    }

    public void setPlanEnd(Date planEnd) {
        this.planEnd = planEnd;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "ToDoEntity{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", planStart=" + planStart +
                ", planEnd=" + planEnd +
                ", status=" + status +
                ", id=" + id +
                '}';
    }

    public ToDoEntity() {
    }

    public ToDoEntity(String name, String description, Date planStart, Date planEnd, int status, int id) {
        this.name = name;
        this.description = description;
        this.planStart = planStart;
        this.planEnd = planEnd;
        this.status = status;
        this.id = id;
    }
}

