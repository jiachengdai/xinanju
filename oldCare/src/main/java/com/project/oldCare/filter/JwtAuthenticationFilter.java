package com.project.oldCare.filter;

import cn.hutool.core.util.StrUtil;
import com.project.oldCare.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

/**
 * 进行登录的过滤器
 * 对token进行校验
 */

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

//	@Resource
//	JwtUtils jwtUtils;
//	@Autowired
//	RedisUtils redisUtil;
	@Override
	protected void doFilterInternal(jakarta.servlet.http.HttpServletRequest request, jakarta.servlet.http.HttpServletResponse response, jakarta.servlet.FilterChain filterChain) throws jakarta.servlet.ServletException, IOException {

		JwtUtils jwtUtils = new JwtUtils();
//		RedisUtils redisUtil = new RedisUtils();
		//获取当前请求url
//		String url = request.getRequestURI();
//		if(url.endsWith("/login")){
//			// 放行
//			filterChain.doFilter(request,response);
//		}
		String jwt = request.getHeader(jwtUtils.getHeader());
		if (StrUtil.isBlankOrUndefined(jwt)) {
			filterChain.doFilter(request, response);
			return;
		}

		Claims claim = jwtUtils.getClaimByToken(jwt);
		if (claim == null) {
			throw new JwtException("token 异常");
		}
		if (jwtUtils.isTokenExpired(claim)) {
			throw new JwtException("token已过期");
		}

		// 3. 从缓存中获取用户信息
//		String redisKey = "login:" + claim;
//		com.project.oldcare_demo5.entity.User user= (com.project.oldcare_demo5.entity.User) redisUtil.get(redisKey);
//		if (Objects.isNull(user)) {
//			throw new RemoteException("用户未登陆");
//		}

		// 4. 存入 SecurityContextHolder，为了做授权使用 FilterSecurityInterceptor
//		UsernamePasswordAuthenticationToken authenticationToken
//				= new UsernamePasswordAuthenticationToken(new LoginUser(user,null), null,null);
//		SecurityContextHolder.getContext().setAuthentication(authenticationToken);


		// 5.放行
		filterChain.doFilter(request,response);
	}

}

