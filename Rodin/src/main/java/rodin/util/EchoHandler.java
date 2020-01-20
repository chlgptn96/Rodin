package rodin.util;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.socket.BinaryMessage;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.PongMessage;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class EchoHandler extends TextWebSocketHandler {

	private static final Logger logger = LoggerFactory.getLogger(EchoHandler.class);
	private List<WebSocketSession> sessionList = new ArrayList<WebSocketSession>();
	
	@Override
	protected void handleBinaryMessage(WebSocketSession session, BinaryMessage message) {
		// TODO Auto-generated method stub
		super.handleBinaryMessage(session, message);
	}

	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		// 클라이언트와 연결
		sessionList.add(session);
		logger.info("{} 연결됨", session.getId());
		logger.debug("입장자: " + session.getPrincipal().getName());
	}

	@Override
	public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {

	}

	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		// 서버로 데이터 전송
		logger.info("{}로부터 {}받음", session.getId(), message.getPayload());
		for (WebSocketSession sess: sessionList) {
			sess.sendMessage(new TextMessage(session.getPrincipal().getName() + " | " + message.getPayload()));
		}
		// session.sendMessage(new TextMessage("echo: " + message.getPayload()));
	}

	@Override
	protected void handlePongMessage(WebSocketSession session, PongMessage message) throws Exception {
		// TODO Auto-generated method stub
		super.handlePongMessage(session, message);
	}

	@Override
	public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
		// TODO Auto-generated method stub
		super.handleTransportError(session, exception);
	}

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		// 연결 끊김
		sessionList.remove(session);
		logger.info("{} 연결 끊김.", session.getId());
		logger.debug("퇴장자: " + session.getPrincipal().getName());
	}

	@Override
	public boolean supportsPartialMessages() {
		// TODO Auto-generated method stub
		return super.supportsPartialMessages();
	}
	
	
}
