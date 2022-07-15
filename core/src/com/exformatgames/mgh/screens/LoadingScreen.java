package com.exformatgames.mgh.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.exformatgames.mgh.audio.Musics;
import com.exformatgames.mgh.audio.Sounds;

public class LoadingScreen implements Screen {

    private final Game game;
    private AssetManager assetManager;
    private Viewport viewport;
    private OrthographicCamera camera;
    private Sprite backgroundSprite;
    private SpriteBatch batch;
    private ShapeRenderer shapeRenderer;

    public LoadingScreen(Game game) {
        this.game = game;
    }

    @Override
    public void show() {
        camera = new OrthographicCamera();
        viewport = new ExtendViewport(12.8f, 7.2f, 24f, 10.8f, camera);
        viewport.apply(true);

        batch = new SpriteBatch();
        shapeRenderer = new ShapeRenderer();
        assetManager = new AssetManager();

        backgroundSprite = new Sprite(new Texture("loading_background.png"));
        backgroundSprite.setSize(7.2f, 7.2f);
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 0, 0, 1, true);

        camera.update();
        batch.setProjectionMatrix(camera.combined);
        shapeRenderer.setProjectionMatrix(camera.combined);

        batch.begin();
        backgroundSprite.draw(batch);
        batch.end();

        assetManager.update();

        float loadingLine = viewport.getWorldWidth() * assetManager.getProgress();
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.rect(0, 0.5f, loadingLine, 1);
        shapeRenderer.end();


        if(assetManager.isFinished()){
            Sounds.init(assetManager);
            Musics.init(assetManager);

            StartScreen startScreen = new StartScreen(game, assetManager, null);
            game.setScreen(startScreen);

        }
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height, true);
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
