/*
 * Copyright 2002-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.beans.factory.config;

import org.springframework.beans.BeansException;

/**
 * Allows for custom modification of an application context's bean definitions,
 * adapting the bean property values of the context's underlying bean factory.
 *
 * <p>Application contexts can auto-detect BeanFactoryPostProcessor beans in
 * their bean definitions and apply them before any other beans get created.
 *
 * <p>Useful for custom config files targeted at system administrators that
 * override bean properties configured in the application context.
 *
 * <p>See PropertyResourceConfigurer and its concrete implementations
 * for out-of-the-box solutions that address such configuration needs.
 *
 * <p>A BeanFactoryPostProcessor may interact with and modify bean
 * definitions, but never bean instances. Doing so may cause premature bean
 * instantiation, violating the container and causing unintended side-effects.
 * If bean instance interaction is required, consider implementing
 * {@link BeanPostProcessor} instead.
 *
 * @author Juergen Hoeller
 * @since 06.07.2003
 * @see BeanPostProcessor
 * @see PropertyResourceConfigurer
 */
@FunctionalInterface
public interface BeanFactoryPostProcessor {
	/**
	 * 允许自定义修改应用上下文的 bean 定义，调整上下文底层 bean 工厂的 bean 属性值。
	 * 应用程序上下文可以在它们的 bean 定义中自动检测 BeanFactoryPostProcessor beans，并在创建任何其他 beans 之前应用它们。
	 * 对于针对系统管理员的自定义配置文件很有用，这些配置文件会覆盖在应用程序上下文中配置的 bean 属性。
	 * 请参阅 PropertyResourceConfigurer 及其具体实现，了解满足此类配置需求的现成解决方案。
	 * BeanFactoryPostProcessor 可以与 bean 定义交互并修改 bean 定义，但不能与 bean 实例交互。
	 * 这样做可能会导致 bean 过早实例化，违反容器并导致意外的副作用。 如果需要 bean 实例交互，请考虑改为实现 BeanPostProcessor。
	 *
	 * 我们要看的下一个扩展点是 org.springframework.beans.factory.config.BeanFactoryPostProcessor。
	 * 该接口的语义类似于 BeanPostProcessor 的语义，有一个主要区别：BeanFactoryPostProcessor 对 bean 配置元数据进行操作。
	 * 也就是说，Spring IoC 容器允许 BeanFactoryPostProcessor 读取配置元数据并可能在容器实例化 BeanFactoryPostProcessor 实例以外的任何 bean 之前更改它。
	 * 你可以配置多个 BeanFactoryPostProcessor 实例，你可以通过设置 order 属性来控制这些 BeanFactoryPostProcessor 实例运行的顺序。
	 * 但是，如果 BeanFactoryPostProcessor 实现了 Ordered 接口，则只能设置此属性。
	 * 如果您编写自己的 BeanFactoryPostProcessor，您也应该考虑实现 Ordered 接口。
	 * 有关详细信息，请参阅 BeanFactoryPostProcessor 和 Ordered 接口的 javadoc。
	 *
	 * 当在 ApplicationContext 中声明时，bean 工厂后处理器会自动运行，以便将更改应用到定义容器的配置元数据。
	 * Spring 包括许多预定义的 bean 工厂后处理器，例如 PropertyOverrideConfigurer 和 PropertySourcesPlaceholderConfigurer。
	 * 您还可以使用自定义 BeanFactoryPostProcessor⟩——例如，注册自定义属性编辑器。
	 * ApplicationContext 会自动检测部署到其中的任何实现 BeanFactoryPostProcessor 接口的 beans。
	 * 它在适当的时候将这些 bean 用作 bean 工厂后处理器。 您可以像部署任何其他 bean 一样部署这些后处理器 bean。
	 *
	 * BeanFactoryPostProcessor 作用
	 * BeanFactoryPostProcessor 主要作用是在注册 BeanDefinition 之后，在 Bean 初始化之前，修改 BeanDefinition 的信息。
	 * BeanFactoryPostProcessor 有个实现叫 BeanDefinitionRegistryPostProcessor，它可以额外的注册新的 BeanDefinition 到容器中。
	 */

	/**
	 * Modify the application context's internal bean factory after its standard
	 * initialization. All bean definitions will have been loaded, but no beans
	 * will have been instantiated yet. This allows for overriding or adding
	 * properties even to eager-initializing beans.
	 * @param beanFactory the bean factory used by the application context
	 * @throws org.springframework.beans.BeansException in case of errors
	 */
	void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException;

}
