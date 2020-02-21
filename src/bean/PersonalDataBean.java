package bean;

import org.apache.commons.logging.Log;

/**
 * created by chenyang
 * on 2020/2/21
 */
public class PersonalDataBean {

    //未请假也未参加训练
    public class Absent{
        //缺席的时间
        private long absentTime;
        //缺席的训练项目
        private String absentProject;

        public long getAbsentTime() {
            return absentTime;
        }

        public void setAbsentTime(long absentTime) {
            this.absentTime = absentTime;
        }

        public String getAbsentProject() {
            return absentProject;
        }

        public void setAbsentProject(String absentProject) {
            this.absentProject = absentProject;
        }
    }
    //请假
    public class Leave{
        //请假时间
        private long leaveTime;
        //请假的项目
        private String leaveProject;
        //请假的原因
        private String leaveReason;

        public long getLeaveTime() {
            return leaveTime;
        }

        public void setLeaveTime(long leaveTime) {
            this.leaveTime = leaveTime;
        }

        public String getLeaveProject() {
            return leaveProject;
        }

        public void setLeaveProject(String leaveProject) {
            this.leaveProject = leaveProject;
        }

        public String getLeaveReason() {
            return leaveReason;
        }

        public void setLeaveReason(String leaveReason) {
            this.leaveReason = leaveReason;
        }
    }


}
