package com.game7d.rtsgame.Scenes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class Controller {
    Viewport viewport;
    public Stage stage;
    public boolean upPressed, downPressed, leftPressed, rightPressed;
    OrthographicCamera cam;

    public Controller(SpriteBatch sb){
        cam = new OrthographicCamera();
        viewport = new FitViewport(256, 256, cam);
        stage = new Stage(viewport, sb);

        Gdx.input.setInputProcessor(stage);

        Table table = new Table();
        table.left().bottom();


        Image upImg = new Image(new Texture("zoom_in.png"));
        upImg.setSize(25, 25);
        upImg.addListener(new InputListener() {

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                upPressed = true;
                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                upPressed = false;
            }
        });

        Image downImg = new Image(new Texture("zoom_out.png"));
        downImg.setSize(25, 25);
        downImg.addListener(new InputListener() {

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                downPressed = true;
                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                downPressed = false;
            }
        });




        table.add();
        table.add(upImg).size(upImg.getWidth(), upImg.getHeight());
        table.add();
        table.row().pad(10, 10, 10, 10);
        table.add();
        table.add(downImg).size(downImg.getWidth(), downImg.getHeight());
        table.add();

        stage.addActor(table);
    }

    public void draw(){
        stage.draw();
    }

    public boolean isUpPressed() {
        return upPressed;
    }

    public boolean isDownPressed() {
        return downPressed;
    }

    public boolean isLeftPressed() {
        return leftPressed;
    }

    public boolean isRightPressed() {
        return rightPressed;
    }

    public void resize(int width, int height) {
        viewport.update(width, height);
        stage.getViewport().update(width, height, true);

        Table table = new Table();
        table.right().center(); // Align the table to the right and center vertically

        Image upImg = new Image(new Texture("zoom_in.png"));
        upImg.setSize(25, 25);

        Image downImg = new Image(new Texture("zoom_out.png"));
        downImg.setSize(25, 25);

        table.add(upImg).size(upImg.getWidth(), upImg.getHeight()).padBottom(10);
        table.row();
        table.add(downImg).size(downImg.getWidth(), downImg.getHeight());

        stage.clear();
        stage.addActor(table);
    }



}