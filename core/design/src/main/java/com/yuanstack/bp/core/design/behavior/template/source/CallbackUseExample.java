package com.yuanstack.bp.core.design.behavior.template.source;

import java.util.AbstractList;

/**
 * @description: 回调在JdbcTemplate中的应用
 * @author: hansiyuan
 * @date: 2022/3/30 11:53 AM
 */
public class CallbackUseExample {
    public static void main(String[] args) {
        // Callback在JdbcTemplate中的应用
        callbackInJdbcTemplate();
        // Callback在前端OnClick中的应用（略）
        // Callback在关闭钩子中的应用
        callbackInShutdownHook();
    }

    private static void callbackInShutdownHook() {
//        1、public class Runtime
//            1.1、public void addShutdownHook(Thread hook)
//        2、class ApplicationShutdownHooks
//            2.1、static synchronized void add(Thread hook)
//            2.2、static void runHooks()
        Runtime.getRuntime().addShutdownHook(new ShutdownHook());
    }

    private static class ShutdownHook extends Thread {
        @Override
        public void run() {
            System.out.println("I am called during shutting down.");
        }
    }

    private static void callbackInJdbcTemplate() {
//        public <T > List < T > query(String sql, RowMapper < T > rowMapper) throws DataAccessException {
//        public <T > T query( final String sql, final ResultSetExtractor<T> rse) throws DataAccessException {
//            class QueryStatementCallback implements StatementCallback<T>, SqlProvider {
//                public T doInStatement(Statement stmt) throws SQLException {
//                public String getSql() {
//        }
//        public <T > T execute(StatementCallback < T > action) throws DataAccessException {
    }
}