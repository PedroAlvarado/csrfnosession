package com.example.csrfbug

import kotlinx.coroutines.reactive.awaitSingle
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.web.server.ServerHttpSecurity
import org.springframework.security.config.web.server.ServerHttpSecurity.http
import org.springframework.security.config.web.server.invoke
import org.springframework.security.web.reactive.result.view.CsrfRequestDataValueProcessor
import org.springframework.security.web.server.SecurityWebFilterChain
import org.springframework.security.web.server.csrf.CookieServerCsrfTokenRepository
import org.springframework.security.web.server.csrf.CsrfToken
import org.springframework.security.web.server.util.matcher.PathPatternParserServerWebExchangeMatcher
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.buildAndAwait
import org.springframework.web.reactive.function.server.coRouter
import reactor.core.publisher.Mono

@SpringBootApplication
@EnableConfigurationProperties
class CsrfbugApplication

fun main(args: Array<String>) {
    runApplication<CsrfbugApplication>(*args)
}

@Configuration
class Configs {

    @Bean
    fun springSecurityFilterChain(http: ServerHttpSecurity): SecurityWebFilterChain {
        return http {
            httpBasic {  }
            formLogin {  }
            authorizeExchange {
                authorize(anyExchange, authenticated)
            }
            csrf {
                csrfTokenRepository = CookieServerCsrfTokenRepository.withHttpOnlyFalse()
            }
        }
    }

}