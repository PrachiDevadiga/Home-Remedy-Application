package com.example.homeremedy;

/*public class remedies {
    private int imageResourceId;
    private String title;
    private String myproj;
    private String remedy;
    //private String description;
    private boolean expand;

    public remedies(int imageResourceId, String title, String myproj, String remedy) {
        this.imageResourceId = imageResourceId;
        this.title = title;
        this.myproj = myproj;
        this.remedy = remedy;
        //this.description = description;
        this.expand = false;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public void setImageResourceId(int imageResourceId) {
        this.imageResourceId = imageResourceId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMyproj() {
        return myproj;
    }

    public void setMyproj(String myproj) {
        this.myproj = myproj;
    }

    public String getRemedy() {
        return remedy;
    }

    public void setRemedy(String remedy) {
        this.remedy = remedy;
    }

    /*public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }*/

    /*public boolean isExpand() {
        return expand;
    }

    public void setExpand(boolean expand) {
        this.expand = expand;
    }

    @Override
    public String toString() {
        return "remedies{" +
                "imageResourceId=" + imageResourceId +
                ", title='" + title + '\'' +
                ", myproj='" + myproj + '\'' +
                ", remedy='" + remedy + '\'' +
                //", description='" + description + '\'' +
                ", expand=" + expand +
                '}';
    }
}*/
   /* public class remedies {
        private String myproj;
        private String remedy;
        private String description;
        //private int imageResourceId;
        private boolean expand;

        public boolean isExpand() {
            return expand;
        }

        public void setExpand(boolean expand) {
            this.expand = expand;
        }

        public remedies(String myproj, String remedy, String description) {
            this.myproj = myproj;
            this.remedy = remedy;
            this.description = description;
            //this.imageResourceId = imageResourceId;
            this.expand = false;
        }

        public String getMyProj() {
            return myproj;
        }

        public void setMyProj(String myproj) {
            this.myproj = myproj;
        }

        public String getRemedy() {
            return remedy;
        }

        public void setRemedy(String remedy) {
            this.remedy = remedy;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        /*public int getImageResourceId() {
            return imageResourceId;
        }

        public void setImageResourceId(int imageResourceId) {
            this.imageResourceId = imageResourceId;
        }*/

      /*  @Override
        public String toString() {
            return "remedies{" +
                    "myproj='" + myproj + '\'' +
                    ", remedy='" + remedy + '\'' +
                    ", description='" + description + '\'' +
                    ", expand=" + expand +
                    '}';
        }
    }*/

public class remedies {
    private String myproj,remedy,description;
    private int imageResource;
    private boolean expand;

    public boolean isExpand(){
        return expand;
    }

    public void setExpand(boolean expand)
    {
        this.expand=expand;
    }

    public remedies(int imageResource,String myproj,String remedy,String description){
        this.imageResource = imageResource;
        this.myproj=myproj;
        this.remedy=remedy;
        this.description=description;
        this.expand=false;
    }

    public int getImageResource() {
        return imageResource;
    }

    public void setImageResource(int imageResource) {
        this.imageResource = imageResource;
    }
    public String getMyProj(){

        return myproj;
    }
    public void setMyProj(String myproj){

        this.myproj=myproj;
    }
    public String getRemedy(){

        return remedy;
    }
    public void setRemedy(String myproj){
        this.remedy=remedy;
    }
    public String getDescription(){

        return description;
    }
    public void setDescription(String myproj){

        this.description=description;
    }


    public String getTitle() {
        return myproj;
    }


    public String toString(){
        return "remedy{" +
                "imageResource=" + imageResource +
                ",  myproj='" + myproj + '\'' +
                ", remedy='" + remedy + '\'' +
                //", description='" + description + '\'' +
                ", expand=" + expand +
                '}';
    }

}
