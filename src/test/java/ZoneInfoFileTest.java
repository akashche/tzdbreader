/*
 * Copyright 2015 Red Hat, Inc.
 *
 * This file is part of tzdbgen.
 *
 * tzdbgen is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published
 * by the Free Software Foundation; either version 2, or (at your
 * option) any later version.
 *
 * tzdbgen is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with tzdbgen; see the file COPYING.  If not see
 * <http://www.gnu.org/licenses/>.
 *
 * Linking this code with other modules is making a combined work
 * based on this code.  Thus, the terms and conditions of the GNU
 * General Public License cover the whole combination.
 *
 * As a special exception, the copyright holders of this code give
 * you permission to link this code with independent modules to
 * produce an executable, regardless of the license terms of these
 * independent modules, and to copy and distribute the resulting
 * executable under terms of your choice, provided that you also
 * meet, for each linked independent module, the terms and conditions
 * of the license of that module.  An independent module is a module
 * which is not derived from or based on this code.  If you modify
 * this code, you may extend this exception to your version of the
 * library, but you are not obligated to do so.  If you do not wish
 * to do so, delete this exception statement from your version.
 */

import tzdb.java.util.TimeZone;
import tzdb.sun.util.calendar.ZoneInfoFile;
import org.junit.Test;

import java.io.File;
import java.net.URI;
import java.util.Arrays;

/**
 * tzdb.dat load test
 */
public class ZoneInfoFileTest {

    @Test
    public void test() throws ClassNotFoundException {
        File projectDir = codeSourceDir(ZoneInfoFileTest.class).getParentFile().getParentFile();
//        System.out.println(new File(projectDir, "src/test/resources").getAbsolutePath());
        System.setProperty("tzdb.java.home", new File(projectDir, "src/test/resources").getAbsolutePath());
        ZoneInfoFile.fireLoad();
        System.out.println(ZoneInfoFile.getVersion());
        System.out.println(TimeZone.getTimeZone("Europe/Dublin"));
        System.out.println(TimeZone.getTimeZone("America/Toronto"));
        System.out.println(TimeZone.getTimeZone("Asia/Tehran"));
//        System.out.println(Arrays.toString(TimeZone.getAvailableIDs()));
    }

    private static File codeSourceDir(Class<?> clazz) {
        try {
            URI uri = clazz.getProtectionDomain().getCodeSource().getLocation().toURI();
            File jarOrDir = new File(uri);
            return jarOrDir.isDirectory() ? jarOrDir : jarOrDir.getParentFile();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
