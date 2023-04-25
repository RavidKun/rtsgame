package com.game7d.rtsgame.Scenes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.game7d.rtsgame.rtsgame;

public class DemoScreen implements Screen {

    private rtsgame game;
    private OrthographicCamera gamecam;
    private Viewport gamePort;
    private Texture texture;

    public DemoScreen(rtsgame game) {
        this.game = game;
        texture =new Texture("badlogic.jpg");
        gamecam = new OrthographicCamera();
        gamePort = new FitViewport(400,240,gamecam);
        //gamecam.position.set(0,0,0);

    }
    public void handleInput(float dt){
        if(Gdx.input.isTouched())
            gamecam.position.x+=100*dt;



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
        game.batch.draw(texture,-50,-50);
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
