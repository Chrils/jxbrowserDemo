package org.example.util;

import java.util.Objects;

public class PathUtil {

    public static class PathBuilder {
        private StringBuilder path;

        private PathBuilder(String raw) {
            path = new StringBuilder(raw);
        }


        public static final String FILE_STRATEGY = "file://";

        public static final String HTTP_STRATEGY = "http://";

        public static final String HTTPS_STRATEGY = "https://";

        public PathBuilder withFileStrategy() {
            path.insert(0,FILE_STRATEGY);
            return this;
        }

        public PathBuilder withHttpStrategy() {
            path.insert(0,HTTP_STRATEGY);
            return this;
        }

        public PathBuilder withHttpsStrategy() {
            path.insert(0,HTTPS_STRATEGY);
            return this;
        }

        public PathBuilder sourceName(String srcName) {
            path.append(srcName);
            return this;
        }

        public String build() {
            String res = path.toString();
            path = null; // help GC
            return res;
        }


    }

    public static PathBuilder getResourceURI() {
        return new PathBuilder(Objects.requireNonNull(PathUtil.class.getClassLoader().getResource("")).getPath());
    }

}
