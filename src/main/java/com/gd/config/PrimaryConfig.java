/*
 * Copyright 2015 the original author or authors.
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
package com.gd.config;

import com.gd.models.customer.Customer;
import com.gd.models.entities.Phone;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

/**
 * Configuration for the {@link Customer} slice of the system. A dedicated {@link DataSource},
 * {@link JpaTransactionManager} and {@link EntityManagerFactory}. Note that there could of course be some deduplication
 * with {@link example.springdata.jpa.multipleds.order.OrderConfig}. I just decided to keep it to focus on the
 * sepeartion of the two. Also, some overlaps might not even occur in real world scenarios (whether to create DDl or the
 * like).
 *
 * @author Oliver Gierke
 */
@Configuration
@EnableJpaRepositories(entityManagerFactoryRef = "primaryEntityManagerFactory",
		transactionManagerRef = "primaryTransactionManager")
class PrimaryConfig {

	@Bean
	PlatformTransactionManager primaryTransactionManager() {
		return new JpaTransactionManager(primaryEntityManagerFactory().getObject());
	}

	@Bean
	LocalContainerEntityManagerFactoryBean primaryEntityManagerFactory() {

		HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
		jpaVendorAdapter.setGenerateDdl(true);

		LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();

		factoryBean.setDataSource(primaryDataSource());
		factoryBean.setJpaVendorAdapter(jpaVendorAdapter);
		factoryBean.setPackagesToScan(Phone.class.getPackage().getName());

		return factoryBean;
	}

	@Bean
	@ConfigurationProperties(prefix="spring.datasource")
	DataSource primaryDataSource() {
		return DataSourceBuilder.create().build();
	}
}
