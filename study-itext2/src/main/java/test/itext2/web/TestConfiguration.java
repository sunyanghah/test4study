package test.itext2.web;

import io.dropwizard.Configuration;
import org.rnorth.dropwizard.markdown.MarkdownAssetsConfiguration;
import org.rnorth.dropwizard.markdown.MarkdownBundleConfiguration;

/**
 * @author sunYang
 * @date 2022/8/11 15:55
 */
public class TestConfiguration extends Configuration implements MarkdownBundleConfiguration {

    public MarkdownAssetsConfiguration assets = new MarkdownAssetsConfiguration();

    @Override
    public MarkdownAssetsConfiguration getMarkdownAssetsConfiguration() {
        return assets;
    }


}
