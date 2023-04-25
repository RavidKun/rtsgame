package com.game7d.rtsgame;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.game7d.rtsgame.Scenes.DemoScreen;

public class rtsgame extends Game {
	public SpriteBatch batch;

	
	@Override
	public void create () {
		batch = new SpriteBatch();
		setScreen(new DemoScreen(this));
	}

	@Override
	public void render () {

	}
	
	@Override
	public void dispose () {

	}
}
