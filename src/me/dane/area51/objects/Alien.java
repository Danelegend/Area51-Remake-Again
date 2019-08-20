package me.dane.area51.objects;

import me.dane.area51.GameHandler;
import me.dane.area51.framework.GameObject;
import me.dane.area51.framework.ObjectId;

import java.awt.*;
import java.util.LinkedList;

public class Alien extends GameObject {

    private GameHandler gh;
    private Image img;
    private final int width = 50;
    private final int height = 100;

    private boolean hit;

    public Alien(float x, float y, ObjectId id, GameHandler gh) {
        super(x, y, id);
        String location = "rick-and-morty-hq-resource-pink-rick-and-motry-alien-character-png-clipart-thumbnail.jpg ";
        img = Toolkit.getDefaultToolkit().getImage(location);
        this.gh = gh;
        this.hit = false;
    }

    private void collision(LinkedList<GameObject> obj) {
        for (int i = 0; i < obj.size(); i++) {
            GameObject tempObj = gh.obj.get(i);

            if (tempObj.getId() == ObjectId.Player) {

                if (getBoundsTop().intersects(tempObj.getBounds())) {
                    hit = true;
                    removeAlien();
                }

                if (getBoundsLeft().intersects(tempObj.getBounds())) {
                    hit = true;
                    removeAlien();
                }

                if (getBoundsRight().intersects(tempObj.getBounds())) {
                    hit = true;
                    removeAlien();
                }

                if (getBounds().intersects(tempObj.getBounds())) {
                    hit = true;
                    removeAlien();
                }

            }

        }
    }

    private void removeAlien() {
        gh.removeAlien();
    }

    public void tick(LinkedList<GameObject> obj) {
        collision(obj);
    }

    public void render(Graphics g) {
        g.drawImage(img, (int) x, (int) y, width, height, null);
    }

    public Rectangle getBounds() {
        return new Rectangle((int) ((int)x + (width/2) - ((width/2)/2)), (int) ((int) y+(height/2)), (int) width/2, (int) height/2);
    }

    public Rectangle getBoundsTop() {
        return new Rectangle((int) ((int)x + (width/2) - ((width/2)/2)), (int) y, (int) width/2, (int) height/2);
    }

    public Rectangle getBoundsRight() {
        return new Rectangle((int) ((int) x + width - 5), (int) y + 5, (int) 5, (int) height - 10);
    }

    public Rectangle getBoundsLeft() {
        return new Rectangle((int) x, (int) y + 5, (int) 5, (int) height - 10);
    }

    public boolean isHit() {
        return hit;
    }

}
