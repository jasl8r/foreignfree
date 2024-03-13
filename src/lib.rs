use async_trait::async_trait;
use std::sync::Arc;

uniffi::include_scaffolding!("foreignfree");

#[async_trait]
pub trait ForeignTrait: Send + Sync {
    async fn on_async(&self);
}

pub struct Runner;

impl Runner {
    fn new() -> Self {
        Self {}
    }
    
    async fn run(&self, foreign: Arc<dyn ForeignTrait>) {
        foreign.on_async().await;
    }
}
