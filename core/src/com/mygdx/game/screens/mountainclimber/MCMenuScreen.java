package com.mygdx.game.screens.mountainclimber;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.screens.DanielSandboxScreen;
import com.mygdx.game.screens.HenrySandboxScreen;
import com.mygdx.game.screens.MainMenuScreen;

/**
 * Created by dgli on 02/01/15.
 */
public class MCMenuScreen implements Screen, InputProcessor{
    MyGdxGame game;

    Skin skin;
    Stage stage;

    public MCMenuScreen(MyGdxGame backInst){
        game = backInst;
    }

    @Override
    public void show() {
        skin = new Skin(Gdx.files.internal("ui/uiskin.json"));
        stage = new Stage(new ScreenViewport());

        InputMultiplexer inputMux = new InputMultiplexer();
        inputMux.addProcessor(this);
        inputMux.addProcessor(stage);

        Gdx.input.setInputProcessor(inputMux);

        Button startClimberGameButton = new TextButton("Mountain Climber", skin);

        startClimberGameButton.pad(20);

        // my own table
        Table table = new Table();

        table.row();
        table.add(startClimberGameButton).pad(25);

        table.setFillParent(true);
        stage.addActor(table);

        startClimberGameButton.addListener(new ChangeListener() {
            public void changed(ChangeEvent event, Actor actor) {
                game.setScreen(new HenrySandboxScreen(game));
                dispose();
            }
        });


    }

    @Override
    public void render(float delta) {

        Gdx.gl.glClearColor(0.2f, 0.2f, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        //fpsLabel.setText("fps: " + Gdx.graphics.getFramesPerSecond());

        stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
        stage.draw();

    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
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

    @Override
    public boolean keyDown(int keycode) {
        if(keycode == Input.Keys.BACK){
            game.setScreen(new MainMenuScreen(game));
            return true;
        }
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}