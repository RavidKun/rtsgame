package com.game7d.rtsgame.Scenes;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.game7d.rtsgame.rtsgame;

public class DemoScreen implements Screen {

    private rtsgame game;
    private OrthographicCamera gamecam;
    private Viewport gamePort;

    public DemoScreen(rtsgame game) {
        this.game = game;
        gamecam = new OrthographicCamera();
        gamePort = new FitViewport(820,420,gamecam);
        //gamecam.position.set(0,0,0);

    }

    @Override
    public void show() {
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0,0,0,1);
        game.batch.setProjectionMatrix(gamecam.combined);
        game.batch.begin();

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

    }
}
