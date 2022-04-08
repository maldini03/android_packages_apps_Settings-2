/*
 * Copyright (C) 2020 Wave-OS
 * Copyright (C) 2021 ShapeShiftOS
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

package com.android.settings.deviceinfo.aboutphone;

import java.io.IOException;
import android.content.Context;
import android.os.SystemProperties;
import android.widget.TextView;
import androidx.preference.PreferenceFragmentCompat;
import androidx.preference.PreferenceScreen;

import androidx.preference.PreferenceScreen;

import com.android.settings.R;
import com.android.settings.utils.BananaSpecUtils;
import com.android.settingslib.core.AbstractPreferenceController;
import com.android.settingslib.widget.LayoutPreference;
import com.android.settingslib.Utils;
import com.android.settings.core.PreferenceControllerMixin;

public class BananaInfoPreferenceController extends AbstractPreferenceController {

    private static final String KEY_BANANA_INFO = "banana_info";

    public BananaInfoPreferenceController(Context context) {
        super(context);
    }

    @Override
    public void displayPreference(PreferenceScreen screen) {
        super.displayPreference(screen);
        final LayoutPreference bananaInfoPreference = screen.findPreference(KEY_BANANA_INFO);
        final TextView processor = (TextView) bananaInfoPreference.findViewById(R.id.processor_message);
        final TextView storage = (TextView) bananaInfoPreference.findViewById(R.id.storage_code_message);
        final TextView battery = (TextView) bananaInfoPreference.findViewById(R.id.battery_type_message);
        final TextView infoScreen = (TextView) bananaInfoPreference.findViewById(R.id.screen_message);
        processor.setText(BananaSpecUtils.getProcessorModel());
        storage.setText(String.valueOf(BananaSpecUtils.getTotalInternalMemorySize()) + "GB ROM + " + String.valueOf(BananaSpecUtils.getTotalRAM()) + "GB RAM");
        battery.setText(BananaSpecUtils.getBatteryCapacity(mContext) + " mAh");
        infoScreen.setText(BananaSpecUtils.getScreenRes(mContext));
    }

    @Override
    public boolean isAvailable() {
        return true;
    }

    @Override
    public String getPreferenceKey() {
        return KEY_BANANA_INFO;
    }
}
