package com.exformatgames.mgh.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class StartScreen implements Screen {

    private final Game game;
    private final AssetManager assetManager;
    private final TextureAtlas atlas;

    public StartScreen(Game game, AssetManager assetManager, TextureAtlas atlas) {
        this.game = game;
        this.assetManager = assetManager;
        this.atlas = atlas;
    }

    @Override
    public void show() {
        game.setScreen(new GameScreen(game, assetManager, atlas));
    }

    @Override
    public void render(float delta) {

    }

    @Override
    public void resize(int width, int height) {

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
