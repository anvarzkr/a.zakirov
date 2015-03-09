package ru.kpfu.itis.group11408.zakirov.polyangle;

/**
 * Created by Anvar on 02.03.2015.
 */
public class Polyangle {
    private Vertex[] vertexes;

    public static void main(String[] args) {
        Polyangle polyangle = new Polyangle(new Vertex[]{
            new Vertex(0, 0),
            new Vertex(2, 1),
            new Vertex(0, 2),
            new Vertex(3, 1)
        });

        System.out.println(polyangle.isSharp());
    }

    public boolean isSharp(){
        Vertex v0, v1, v2;
        boolean isSharp = true;

        for (int i = 0; i < this.vertexes.length; i++){
            v0 = this.vertexes[i];
            v1 = (i != 0) ? this.vertexes[i - 1] : this.vertexes[this.vertexes.length - 1];
            v2 = (i != this.vertexes.length) ? this.vertexes[i + 1] : this.vertexes[0];

            if ( (v1.x - v0.x) * (v2.y - v0.y) - (v2.x - v0.x) * (v1.y - v0.y) < 0)
                isSharp = false;
        }

        return isSharp;
    }

    public Polyangle(Vertex[] vertexes) {
        this.vertexes = vertexes;
    }

    public Vertex[] getVertexes() {

        return vertexes;
    }

    public void setVertexes(Vertex[] vertexes) {
        this.vertexes = vertexes;
    }

}
