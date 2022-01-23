/*
 * Copyright (C) 2021 Project Radiant
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.banana.utils;

import android.app.WallpaperManager;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;


public class aboutWallpaperView extends ImageView {

    Context contextM;

    public aboutWallpaperView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        contextM = context;
    }

    public aboutWallpaperView(Context context, AttributeSet attrs) {
        super(context, attrs);
        contextM = context;
    }


    public aboutWallpaperView(Context context) {
        super(context);
        contextM = context;
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        WallpaperManager wallpaperManager = WallpaperManager.getInstance(contextM);
        setImageDrawable(wallpaperManager.getDrawable());
    }

}
