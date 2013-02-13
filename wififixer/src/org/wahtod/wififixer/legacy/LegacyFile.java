/*	    Wifi Fixer for Android
    Copyright (C) 2010-2013  David Van de Ven

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see http://www.gnu.org/licenses
 */

package org.wahtod.wififixer.legacy;

import java.io.File;
import android.content.Context;
import android.os.Environment;

public class LegacyFile extends VersionedFile {
	@Override
	public File vgetLogFile(Context context, String filename) {
		File root = Environment.getExternalStorageDirectory();
		File file = new File(root, filename);
		if (!file.exists()) {
			file.mkdirs();
		}
		return file;
	}
}
