package com.exformatgames.mgh;

import com.badlogic.gdx.Game;
import com.exformatgames.mgh.screens.LoadingScreen;

public class MGHGame extends Game {
	@Override
	public void create () {
		setScreen(new LoadingScreen(this));
	}

}
