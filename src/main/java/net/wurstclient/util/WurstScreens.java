/*
 * Copyright (c) 2014-2025 Wurst-Imperium and contributors.
 *
 * This source code is subject to the terms of the GNU General Public
 * License, version 3. If a copy of the GPL was not distributed with this
 * file, You can obtain one at: https://www.gnu.org/licenses/gpl-3.0.txt
 */
package net.wurstclient.util;

import java.util.List;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ClickableWidget;

public final class WurstScreens
{
	private WurstScreens()
	{}
	
	@SuppressWarnings("unchecked")
	public static List<ClickableWidget> getButtons(Screen screen)
	{
		return (List<ClickableWidget>)(List<?>)screen.drawables;
	}
}
