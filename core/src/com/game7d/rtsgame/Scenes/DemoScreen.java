package com.game7d.rtsgame.Scenes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.game7d.rtsgame.rtsgame;

public class DemoScreen implements Screen {

    private rtsgame game;
    private OrthographicCamera gamecam;
    private Viewport gamePort;
    private Texture texture;
    private float backdeltaX;

    private int countZoom;

    private int mapWidth;
    private int mapHeight;

    public DemoScreen(rtsgame game) {
        this.game = game;
        texture =new Texture("badlogic.jpg");
        gamecam = new OrthographicCamera();
        mapWidth=256;
        mapHeight=256;
        gamePort = new FitViewport(mapWidth,mapHeight,gamecam);
        gamecam.position.set(0,0,0);
        backdeltaX=0;

    }

    public void handleInput(float dt) {
        // Move the camera when two fingers are on the screen
        if ( Gdx.input.isTouched(1)&& !Gdx.input.isTouched(2)) {
            float deltaX = Gdx.input.getDeltaX(0) + Gdx.input.getDeltaX(1);
            float deltaY = Gdx.input.getDeltaY(0) + Gdx.input.getDeltaY(1);

            if(deltaX>0 && gamecam.position.x*gamecam.zoom>-(mapWidth*gamecam.zoom)/2)  // left
            gamecam.translate(-deltaX * dt, 0, 0);

            if(deltaX<0 && gamecam.position.x*gamecam.zoom<(mapWidth*gamecam.zoom)/2)   // right
                //gamecam.translate(-deltaX * dt, deltaY * dt, 0);
                gamecam.translate(-deltaX * dt, 0, 0);

            if(deltaY>0 && gamecam.position.y*gamecam.zoom<=(mapHeight*gamecam.zoom)/2) // down
                gamecam.translate(0, deltaY*dt, 0);

            if(deltaY<0 && gamecam.position.y*gamecam.zoom>-(mapHeight*gamecam.zoom)/2) // up
                gamecam.translate(0, deltaY*dt, 0);



            float initialDistance = Vector2.dst(Gdx.input.getX(0), Gdx.input.getY(0), Gdx.input.getX(1), Gdx.input.getY(1));
            float currentDistance = Vector2.dst(Gdx.input.getX(0) + Gdx.input.getDeltaX(0), Gdx.input.getY(0) + Gdx.input.getDeltaY(0), Gdx.input.getX(1) + Gdx.input.getDeltaX(1), Gdx.input.getY(1) + Gdx.input.getDeltaY(1));
            float distanceDiff = currentDistance - initialDistance;

            if (distanceDiff > 30 && gamecam.zoom>=0.01f){ //   x100 zoom
                gamecam.zoom -= 0.05f;
            } else if (distanceDiff < -30 && gamecam.zoom<=1) { //  all the map
                gamecam.zoom += 0.05f;
            }
            //if(gamecam.position.y<-(mapHeight-(gamecam.zoom*mapHeight)))
             //   gamecam.position.set(gamecam.position.x,-(mapHeight-(gamecam.zoom*mapHeight)),0);
            //if(gamecam.position.x>=mapWidth-(gamecam.zoom*mapWidth))
            //    gamecam.position.set(mapWidth-(gamecam.zoom*mapWidth),gamecam.position.y,0);
        }
    }

    private void update(float delta) {
        handleInput(delta);
        gamecam.update();

    }
    @Override
    public void show() {
    }

    @Override
    public void render(float delta) {
        update(delta);
        ScreenUtils.clear(1,0,0,1);
        game.batch.setProjectionMatrix(gamecam.combined);
        game.batch.begin();
        game.batch.draw(texture,-256/2,-256/2);
        game.batch.end();
    }



    @Override
    public void resize(int width, int height) {
        gamePort.update(width,height);



    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {



    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        texture.dispose();

    }
}