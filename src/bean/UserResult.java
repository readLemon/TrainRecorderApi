package bean;

import java.util.ArrayList;
import java.util.List;

public class UserResult {
    private String name;
    private int age;
    private transient int id;
    private transient String psw;
    //个人的缺训记录
    private List<PersonalDataBean.Absent> absents = new ArrayList<>();
    //个人的请假记录
    private List<PersonalDataBean.Leave> leaves = new ArrayList<>();

    public void clearLeaves() {
        leaves.clear();
    }

    public void addAllLeave(List<PersonalDataBean.Leave> leaves) {
        this.leaves.addAll(leaves);
    }

    public void addLeave(PersonalDataBean.Leave leave) {
        leaves.add(leave);
    }

    public void clearAbsents(){
        absents.clear();
    }

    public void addAllAbsent(List<PersonalDataBean.Absent> absents) {
        this.absents.addAll(absents);
    }

    public void addAbsent(PersonalDataBean.Absent absent) {
        absents.add(absent);
    }

    public List<PersonalDataBean.Absent> getAbsents() {
        return absents;
    }

    public List<PersonalDataBean.Leave> getLeaves() {
        return leaves;
    }

    /**
     * 虽然这么写很不科学，但是现在时间有点赶，先暂时用一下
     */
    public void setListNull(){
        absents = null;
        leaves = null;
    }

    public String getPsw() {
        return psw;
    }

    public void setPsw(String psw) {
        this.psw = psw;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
