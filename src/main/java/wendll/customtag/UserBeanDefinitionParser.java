package wendll.customtag;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSimpleBeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.springframework.util.StringUtils;
import org.w3c.dom.Element;

public class UserBeanDefinitionParser extends AbstractSimpleBeanDefinitionParser {
    @Override
    protected Class<User> getBeanClass(Element element) {
        return User.class;
    }

    @Override
    protected void doParse(Element element, ParserContext parserContext, BeanDefinitionBuilder builder) {
        String userName = element.getAttribute("userName");
        String email = element.getAttribute("email");
        if(StringUtils.hasText(userName)) {
            builder.addPropertyValue("userName", userName);
        }

        if(StringUtils.hasText(email)) {
            builder.addPropertyValue("email", email);
        }
    }
}
